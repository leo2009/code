import java.util.Arrays;


public class SortDemo {

	public static void main(String[] args) {
		
		Integer arr1[] = new Integer[10];
		Integer arr2[] = new Integer[10];
		Integer arr3[] = new Integer[10];
		Integer arr4[] = new Integer[10];
		for(int i=0; i<arr1.length; i++) {
			arr1[i] =  (int) (Math.random()*100);
			arr2[i] =  (int) (Math.random()*100);
			arr3[i] =  (int) (Math.random()*100);
			arr4[i] =  (int) (Math.random()*100);
		}
		bubbleSort(arr1);
		selectSort(arr2);
		insertSort(arr3);
		quickSort(arr4, 0, arr4.length -1);
		
		
		System.out.println("buble..........." + Arrays.asList(arr1));
		System.out.println("select..........." + Arrays.asList(arr2));
		System.out.println("insert..........." + Arrays.asList(arr3));
		System.out.println("quick..........." + Arrays.asList(arr4));

	}
	
	public static void swap(Integer arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void bubbleSort(Integer arr[]) {
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	public static void selectSort(Integer arr[]) {
		for(int i=0; i<arr.length-1; i++) {
			int min = arr[i];
			int minIndex = i;
			for(int j=i+1; j<arr.length; j++) {
				//find min in the remaining arr
				if(arr[j]<min) {
					min = arr[j];
					minIndex = j; 
				}
			}
			swap(arr, i, minIndex);
		}
	}
	
	public static void insertSort(Integer arr[]) {
		for(int i=1; i<arr.length; i++) {
			int current = arr[i];
			int index = i - 1; // index before current
			while(arr[index] > current && index > 0 ) { //if num before current is bigger, push num bk 1 position
				arr[index+1] = arr[index];
				index--;
			}
			arr[index+1] = current;
			
		}
	}
	
	public static int getMiddleIndex(Integer[] arr, int low, int high) {
		int pivot = arr[low];
		while(low<high) {
			while(low<high && arr[high] >= pivot) high--;
			arr[low] = arr[high];
			while(low<high && arr[low] <= pivot) low++;
			arr[high] = arr[low];
		}
		arr[low] = pivot;
		return low;
	}
	
	public static void quickSort(Integer[] arr, int low, int high) {
		if(low >= high)  return;
		int midIndex = getMiddleIndex(arr, low, high);
		quickSort(arr, low, midIndex - 1);
		quickSort(arr, low + 1, high);
		
	}
	
	

}
