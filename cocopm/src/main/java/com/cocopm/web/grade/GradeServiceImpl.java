package com.cocopm.web.grade;

import org.springframework.stereotype.Service;
import com.cocopm.web.util.Credit;

@Service
public class GradeServiceImpl implements GradeService {
	private Grade[] grades;
	private int count;

	public GradeServiceImpl() {
		grades = new Grade[5];
		count = 0;
	}

	@Override
	public void add(Grade grade) {
		grade = grades[count];
		count++;
	}

	@Override
	public int count() {
		return count;
	}

	@SuppressWarnings("static-access")
	@Override
	public Credit detail(String userid) {
		Credit credit = null;
		switch (avg(userid) / 10) {
		case 10:
		case 9:
			credit = credit.A;
			break;
		case 8:
			credit = credit.B;
			break;
		case 7:
			credit = credit.C;
			break;
		case 6:
			credit = credit.D;
			break;
		case 5:
			credit = credit.E;
			break;
		default:
			credit = credit.F;
			break;
		}
		System.out.println(credit);
		return credit;
	}

	private int avg(String userid) {
		return total(userid) / 4;
	}

	private int total(String userid) {
		int total = 0;
		for (int i = 0; i < count; ++i) {
			if (userid.equals(grades[i].getUserid())) {
				total = Integer.parseInt(grades[i].getKorean()) + Integer.parseInt(grades[i].getEnglish())
						+ Integer.parseInt(grades[i].getMath()) + Integer.parseInt(grades[i].getJava()); //Stringify
			}
		}
		System.out.println(total);
		return total;
	}

}
