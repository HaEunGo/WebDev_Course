package project.al.sort;

import java.util.Arrays;

/*
	 * 1. 합병 정렬(Merge Sort)
	 * 	- 병합 정렬(merge sort)은 비교 기반 정렬 알고리즘으로 일반적인 방법으로 구현했을 때 안정 정렬에 속한다.
	 * 		- 안정 정렬 : 반복되는 요소를 입력 때와 동일한 순서로 정렬시키고, 특정한 유형의 데이터를 정렬할 때 정렬 순서 결정 시 데이터의 일부분만 검사
	 * 	- 원소가 저장되어 있는 배열을 작은 단위(1)로 잘개 쪼개서 정렬 후 정렬된 단위들을 계속 병합해가면서 정렬하는 방식 (분할정복)
	 * 	- 임시배열에 원본맵을 계속해서 옮겨주면서 정렬하는 방식
	 * 	- 정렬을 하기 위해서 데이터 전체 크기만한 메모리가 더 필요하다.
	 * 
	 * 
	 * 	1) 합병 정렬의 과정(2-way)
	 * 		1| 주어진 리스트를 2개의 같은 크기로 분할하여 부분 리스트로 나눈다. (Divide : 분할)
	 * 		2| 해당 부분리스트의 길이가 1이 아니라면 1번 과정을 되풀이한다.
	 * 		3| 인접한 부분리스트끼리 정렬한다. 부분집합의 크기가 충분히 작지 않다면 순환호출읋 활용해 더욱 작게 분해한다. (Conquer : 정복)
	 * 		4| 정렬된 부분집합들을 하나로 결합한다.(Combine : 결합)
	 * 
	 * 	2) 장점
	 * 		- 항상 O(NlogN)으로 일정한 속도로 정렬된다.
	 * 		- 알고리즘 중에 가장 간단하고 쉽게 떠올릴 수 있는 방법으로 안정성이 있어 좋은 성능을 나타낸다.
	 * 
	 * 	3) 단점
	 * 		- 정렬과정에서 추가적인 보조 배열 공간을 사용하기 때문에 메모리 사용량이 많은편인데, 추가적인 메모리를 할당할 수 없는 경우 사용할 수 없다.(메모리 활용 비효율적 -> 힙 정렬에서문제 해결)
	 */
public class merge {
	
	
	// top-down 구현 방식
	static int[] sorted = new int [0];
	public static void merge(int a[], int m, int mid, int n) {
		int i = m;				// 첫 번째 부분집합의 시작 위치 설정
		int j = mid + 1;			// 두 번째 부분집합의 시작 위치 설정
		int k = m;				// sorted 배열에 정렬된 원소를 저장할 위치(인덱스) 설정
		
		
		
		while (i <= mid && j < n) {
			/*
			 * 첫 번째 부분 리스트 i번째 원소가 두 번째 부분리스트 j번째 원소보다 작거나 같을 경우,
			 * 첫 번째에 i번째 원소를 새 배열에 넣고 i와 1 증가시킨다.
			 */
			if(a[i]<=a[j]) { 
				
				sorted[k] = a[i];
				i++; 
				
				} else { 
				/*
				 * 두 번째 부분 리스트 j번째 원소가 첫 번째 부분 리스트 i번째 원소보다 작거나 같을 경우,
				 * 두 번째에 j번째 원소를 새 배열에 넣고 j와 1 증가시킨다.
				 */
					sorted[k] = a[j]; 
					j++; 
				} 
				k++; 		// 1씩 증가시킨 값들에 k 또한 1을 증가시킨다.
			}
			
			if (i > mid) {
				/*
				 * 첫 번째 부분 리스트가 먼저 모두 새 배열에 채워졌을 경우(i > mid)
				 * = 두 번째 부분리스트 원소가 아직 남아있을 경우
				 * 두 번째 부분리스트의 나머지 원소들을 새 배열에 채워준다.
				 */
				while (j <= n) {
					sorted[k] = a[j];
					j++;
				}
				
			} else {
				/*
				 *  두 번째 부분 리스트가 먼저 모두 새 배열에 채워졌을 경우 (r > n)
				 *  = 첫 번째 부분 리스트 원소가 아직 남아있을 경우
				 *  첫 번째 부분리스트의 나머지 원소들을 새 배열에 채워준다.
				 */
				while (i <= mid) {
					sorted[k] = a[i];
					i++;
				}
			k++;
			
			}
			
			/*
			 * 정렬된 새 배열을 기존의 배열에 복사하여 옮겨준다.
			 */
			
			for (int q = m; q <= n; q++) {
				a[q] = sorted[q];
			}
			System.out.println("병합 정렬 after : " + Arrays.toString(a));

		}
	
	public static void mergeSort(int a[], int start, int end) {
		int middle; 
		if(start < end) { 
			middle = (start + end)/2;
			merge(a, start, middle, end);		// 앞 부분에 대한 분할 작업 수행
			mergeSort(a, middle+1, end);			// 뒷 부분에 대한 분할 작업 수행
			mergeSort(a, start, middle); 	   // 부분집합에 대하여 정렬과 병합 작업 수행 
				}
			}
		
	public static void main(String[] args) {

		
		int[] list = {243,34,2,1,435,32,43,75,24,19};
		int size = list.length;
		System.out.println("정렬 수행 before : " + Arrays.toString(list));
		mergeSort(list, 0, size-1);
		
	
		}
	}

