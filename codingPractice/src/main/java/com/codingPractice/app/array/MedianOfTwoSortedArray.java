package com.codingPractice.app.array;

public class MedianOfTwoSortedArray {
	public static double findMedianSortedArrays(int A[], int B[]) {
		if(A.length!=0&&B.length!=0){
			double medA, medB;
			int[] newA, newB;
			int length = A.length+B.length;
	        int cutLength = Math.min((A.length-1)/2, (B.length-1)/2);
	        medA = findMedian(A);
	        medB = findMedian(B);
	        if(medA==medB) return (double) medA;
	        else if(A.length<=2||B.length<=2) return judge(A, B, medA, medB, length);
	        else{
	        	newA = cutArray(A, cutLength, medA>medB);
	        	newB = cutArray(B, cutLength, medB>medA);
	        	return findMedianSortedArrays(newA, newB);
	        }
		} 
		else if(A.length!=0&&B.length==0) return findMedian(A);
		else if(A.length==0&&B.length!=0) return findMedian(B);
		else return -1;
    }
	static double findMedian(int[] array){
		int length = array.length;
		if(length%2==0)	return (array[(length-1)/2]+array[length/2])/2.0;
		else return (double) array[length/2];
	}
	static int[] cutArray(int[] array, int length, boolean flag){
		int[] newArray = new int[array.length-length];
		if(flag) System.arraycopy(array, 0, newArray, 0, array.length-length);
		else System.arraycopy(array, length, newArray, 0, array.length-length);
		return newArray;
	}
	static double judge(int[] A, int[] B, double medA, double medB, int length){
		if(A.length==1&&B.length==1) return (medA+medB)/2.0;
		else if(A.length==1) return equalOne(A, B, medA, medB, length);
		else if(B.length==1) return equalOne(B, A, medB, medA, length);
		else if(A.length==2) return equalTwo(A, B, medA, medB, length);
		else return equalTwo(B, A, medB, medA, length);
	}
	static double equalOne(int[] A, int[] B, double medA, double medB, int length){
		if(length%2==0){
			if(medA<medB&&medA<B[B.length/2-1]) return (medB+B[B.length/2-1])/2.0;
			else if(medA>medB&&medA>B[(B.length+1)/2]) return (medB+B[(B.length+1)/2])/2.0;
			else return (medA+medB)/2.0;
		}
		else{
			if(medA<medB&&medA<B[(B.length-1)/2]) return B[(B.length-1)/2];
			else if(medA>medB&&medA>B[B.length/2]) return B[B.length/2];
			else return medA;
		}
	}
	static double equalTwo(int[] A, int[] B, double medA, double medB, int length){
		if(length%2==0){
			if(A[0]>B[(B.length-1)/2]&&A[1]<B[B.length/2]) return medA;
			else if(A[0]<B[(B.length-1)/2]&&A[1]>B[B.length/2]) return medB;
			else if(B.length!=2&&A[1]<B[B.length/2-2]) return (B[(B.length-1)/2]+B[B.length/2-2])/2.0;
			else if(B.length!=2&&A[0]>B[B.length/2+1]) return (B[B.length/2]+B[B.length/2+1])/2.0;
			else if(medA<medB)return (A[1]+B[(B.length-1)/2])/2.0;
			else return (A[0]+B[B.length/2])/2.0;
		}
		else{
			if(A[0]<medB&&A[1]>medB) return medB;
			else if(medB>medA){
				if(B[B.length/2-1]>A[1]) return B[B.length/2-1];
				else return A[1];
			}
			else if(medB<medA){
				if(B[(B.length+1)/2]<A[0]) return B[(B.length+1)/2];
				else return A[0];
			}
			else return medB;
		}
	}
	
	public static void main(String[] args){
		int[] A = {1,2,6,7};
		int[] B = {3,4,5,8};
		System.out.println(findMedianSortedArrays(A,B));
	}
}
