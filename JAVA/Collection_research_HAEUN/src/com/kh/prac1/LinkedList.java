package com.kh.prac1;


	/*
	 * 자료 구조 - 선형 구조 - 리스트 (Linear List / Ordered List)
	 * 		- 배열과 같이 연속되는 기억장소에 저장된다.
	 * 		- 원소 삽입 시 삽입하려는 위치부터 그 뒤의 원소들을 모두 한 칸 씩 뒤로 옮긴 다음 저장해야 한다.
	 * 		- 원소 삭제 시 원소를 삭제하고, 그 뒤의 원소들을 한칸씩 옮겨줘야 한다.
	 * 		- 자료의 개수가 n개 일 때, 삽입 시 평균 이동 횟수 = n+1/2, 삭제 시 평균이동 횟수 = n-1/2
	 * 
	 *  장점 (연결 리스트와 비교시)
	 *  		- 가장 간단한 자료 구조이다.(알고리즘 간단)
	 *  		- 논리적 순서와 물리적 순서가 같기 때문에 접근속도(access time)가 빠르다.
	 *  		- 기억장소를 연속으로 배정받기 때문에 기억장소(저장) 이용 효율은 밀도가 1로써 가장 좋다.
	 *  
	 *  단점 (연결 리스트와 비교시)
	 *  		- 원소의 개수가 많고, 삽입, 삭제 시 자료의 이동이 필요하기 때문에 작업이 번거롭다.
	 *  			-> 오버헤드 증가 -> 성능상 문제 발생
	 *  		- 초기에 배열의 크기를 정해줘야 하고, 순서가 중요한 리스트다.
	 *  
	 * -> 결국 리스트라는 것 자체는 여러 원소를 담아서 관리하는 근원이 되는 자료 구조체고, 리스트를 여러 구조 방식으로 구현해볼 수 있다.
	 *  * 실습은 리스트의 특성을 살린 자료 구조방식인 LinkedList로 해보았습니다.
	 *  * 부끄럽게도 제가 직접 작성해본 코드가 자꾸 오류가 나서 
	 *  
	 */


public class LinkedList {
	Node head;
	
	// 노드 생성
	public void addFirst(String data) {
        if(head == null) {					// head가 null값인 경우(값이 없는 경우)
            head = new Node(data);			// 새 노드가 head가 된다.
            return;
        }
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
	
	}
	
	public void addLast(String data) {
        if(head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;			// 현재 노드를 linkedList의 head로 지정
        while(current.next != null) {	// 현재 노드를 다음 노드로 변경
            current = current.next;
        }
        current.next = new Node(data);
    }
    
	
	// 처음 값 삭제
    public void removeFirst() {
        if(head == null) {
            return;
        }
        head = head.next;
    }
    
    
	// 노드 마지막 값 삭제
    public void removeLast() {
        if(head == null) {
            return;
        }
        if(head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        Node previous = null;
        while(current.next != null) {
            previous = current;
        }
        current = current.next;
        previous.next = null;
    }
    
    // 특정 값 삭제
    public void removeValue(String data) {
        if(head == null) {
            return;
        }
        if(head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null) {
            if(current.next.data.equals(data)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
	 
	public class Node {
	    
	    Node next;
	    String data;
	    
	    public Node(String data) {
	        this.data = data;
	    }

	}
}
