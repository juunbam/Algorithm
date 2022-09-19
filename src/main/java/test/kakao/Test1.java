package test.kakao;
import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String[] answer = {};
		ArrayList<String[]> r = new ArrayList<String[]>();
		ArrayList<String[]> id = new ArrayList<String[]>();

		for(int i=0;i<record.length;i++) {
			String[] tmp = record[i].split(" ");
			r.add(tmp);
		}

		for(int i=0;i<r.size();i++) {
			if(r.get(i)[0].equals("Enter")) {
				if(id.isEmpty()) {
					String[] tmp = new String[2];
					tmp[0]=r.get(i)[1];
					tmp[1]=r.get(i)[2];
					id.add(tmp);
				}
				else {
					for(int j=0;j<id.size();j++) {
						if(id.get(j)[0].equals(r.get(i)[1])) {
							id.get(j)[1]=r.get(i)[2];
							break;
						}
					}
				}
			}
		}
		for(int i=0;i<r.size();i++) {
			if(r.get(i)[0].equals("Enter")) {
				if(id.isEmpty()) {
					String[] tmp = new String[2];
					tmp[0]=r.get(i)[1];
					tmp[1]=r.get(i)[2];
					id.add(tmp);
				}
				else {
					for(int j=0;j<id.size();j++) {
						if(id.get(j)[0].equals(r.get(i)[1])) {
							id.get(j)[1]=r.get(i)[2];
							break;
						}
					}
				}
			}
			else if(r.get(i)[0].equals("Change")) {
				for(int j=0;j<id.size();j++) {
					if(id.get(j)[0].equals(r.get(i)[1])) {
						id.get(j)[2]=id.get(j)[1];
						id.get(j)[1]=r.get(i)[2];
						break;
					}
				}

			}
		}

	}

}
