package chefTeCode;

public class Diet {

	public static void main(String[] args) {
		int size = 3;
		int dailyProtein = 4;

		int arr[] = { 8, 1, 1 };
		int flag = 0;
		int leftProtein = 0;
		for (int i = 0; i < size; i++) {
			int sum = arr[i] + leftProtein;
			if (dailyProtein > sum) {
				System.out.println("NO " + (i + 1));
				flag = 1;
				break;
			} else {
				leftProtein = (sum - dailyProtein);
			}
		}
		if (flag == 0) {
			System.out.println("YES");
		}

	}

}
