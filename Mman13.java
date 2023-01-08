import java.util.*;


/*
Class Quicksort- Functions:

1. QuickSort()
2. Partition()
3. Swap()

*/  

class Quicksort{
	static int cnt=0;
    // QuickSort:
    static void quicksort(int[] A,int p,int r){
        if (p<r) {
            int q=partition(A,p,r);
            quicksort(A, p, q-1);
            quicksort(A, q+1, r);
        }
    }
    // Partition:
    static int partition(int[] A ,int p,int r){
        int x=A[r];
        int i=p-1;
        for (int j=p; j<r; j++) {
            cnt++;
        	if (A[j]<=x) {
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,r);
        return i+1;
    }
    
    // Swap:
    static void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
        
    }


}

// ------------------------------------------------------------------------------------------------------------------------

//  Improved Quicksort

/*
Class Quicksort_b- Functions:

1. quicksort()
2. partition()
3. find_median()
4. Swap()

*/  

class Quicksort_b{
    static int cnt=0;
    // implementation: quicksort(The Array, left element, right element) ==> sort A[l...r]
    static void quicksort(int[] A,int l,int r){
        if (l < r) {
            int q = partition(A, l, r);  // partition A[l...r] 
            quicksort(A, l, q - 1);     // sort A[l...q-1]
            quicksort(A, q + 1, r);    // sort A[q+1...r]
            
        }
    }

    // implementation: partition(The Array, left element, right element) ==> partition A[l...r] to 2 parts

   
    static int partition(int[] A, int l, int r) {
        
        int pivotIndex=(l+r)/2; // use the middle index as the pivot 
        int len=(r-l+1);
        // here I ensure that A[pivotIndex] is not min or max of A[l...r]
         if(len>=3) {
             int left=l;
             int mid=pivotIndex;
             int right=r;

             pivotIndex=find_median(A, left,mid,right);
            //  In find_median function we move the max to the most right and the min to the top left so no need to sort them again
             l++;
             r--;
         }
          
        // Swap the pivot element with the last element in the array so we can compare properly 
        swap(A, pivotIndex, r);
        // This is the partitioning part and it's the same as the original quicksort partition function
        int x=A[r];
        int i = l - 1; 
        for (int j = l; j <r; j++) {
            cnt++;
            if (A[j] <= x) {
                i++;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;   
    }
   
    // implementation: find_median(The Array, left element, right element) ==> sorts first last and middle elements...
    // and put them in the right place (A[left]...A[middle]...A[right]) where A[left]<A[middle]<A[right]...
    // and returns the middle element as the median of these 3 nums.
    public static int find_median(int[] A, int left,int mid, int right) {
        
        cnt++;
        // Ensures that A[left] is the smallest
        if (A[left] > A[mid] ) {
            swap (A,left,mid);
        
        }
        cnt++;
        // Ensures that A[left] is the smallest and A[right] is the biggest 
        if (A[left] > A[right] ) {
            swap (A,left,right);
        
        }
        cnt++;

        // Ensures that A[right] is the biggest
        if (A[mid] > A[right] ) {
            swap (A,mid,right);
        
        }
        // So now the median between the three is in the middle. we return it :)
        return mid;
        
    }

    // Exchanges the positions of two numbers 
    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
}

// Array generator to get all of the permutations of A[1,...,n]
class Generator{
    static int[] gen(int n){
        int[] A=new int[n];
        for(int i=0;i<n;i++){
            A[i]=i+1;
        }
        return A;
    }
    static void generate_next_permutation(int[] A,int n){
          int i=n-2;
          while (i>=0 && A[i]>=A[i+1]){
            i--;
          }
          if (i==-1 ) return;
          int c=i+1;
          for (int j=i+2;j<n;j++){
            if (A[i]<A[j] && A[j]<A[c]) c=j;

          }
          
          swap(A,i,c);

          reverse(A,i+1,n);
          

    }
    static void swap(int[] A,int i,int j){
        if (i!=j){
            int temp=A[i];
            A[i]=A[j];
            A[j]=temp;
        }
    }
    static void reverse(int[] A,int i,int n){
        
        for (int j=n-1;j>i-1;j--){
            swap(A,j,i);
            i++;
        }
    }
    static long fact(int a) {
    	long res=1;
    	for (int i=2; i<=a;i++) {
    		res*=i;
    	}
    	return res;
    }
}






class Mman13 {
    public static void main(String[] args){

        ExcelWriter write_to_excel = new ExcelWriter();

       

        long[] cnts_of_cnta={0};
        long[] cnts_of_cntb={0};
    	Scanner sc= new Scanner(System.in);      
    	System.out.print("Enter max n: ");  
	    int N= sc.nextInt(); 
        sc.close();
        Double[][] data=new Double[11][1+N-3];
        long fact; // Factorial (of n)
        double tavga=0.0; // Total avg of Algo1 (Traditional)
        double tavgb=0.0; // Total avg of Algo1 (Improved)
        double a=0.2; 
        int nIndex=0;
	    for (int n=3;n<=N;n++){
            
            cnts_of_cnta=new long[1+(n*n)/2];
            cnts_of_cntb=new long[1+(n*n)/2];
            tavga=0.0;
            tavgb=0.0;
        
            if (n>1) {	
            
                int[] A=Generator.gen(n);
                fact=Generator.fact(n);
                int[] B=new int[n];
                int[] C=new int[n];

                for (long i=0; i<fact; i++) {
                    Quicksort.cnt=0;
                    Quicksort_b.cnt=0;
                    B= Arrays.copyOf(A, n);
                    C=Arrays.copyOf(A, n);
                    Quicksort.quicksort(B,0,n-1);
                    cnts_of_cnta[Quicksort.cnt]+=1;
                    Quicksort_b.quicksort(C,0,n-1);
                    cnts_of_cntb[Quicksort_b.cnt]+=1;
                    tavga+=Double.valueOf( Quicksort.cnt)/Double.valueOf(fact);
                    tavgb+=Double.valueOf(Quicksort_b.cnt)/Double.valueOf(fact);               
                    Generator.generate_next_permutation(A, n);
                    

                    

                }

             // now we need to find the best a cases and worst a cases
            double best_c_avga=0;
            double worst_c_avga=0;
            double best_c_avgb=0;
            double worst_c_avgb=0;
         
            int elcounter_besta=0;
            int elcounter_worsta=0;
            int elcounter_bestb=0;
            int elcounter_worstb=0;
            for (int i=0;i<cnts_of_cnta.length;i++){
                for (int j=0; j<cnts_of_cnta[i];j++){
                    if (elcounter_besta<a*(fact/2)){
                        elcounter_besta++;
                        best_c_avga+=(Double.valueOf(i)/Double.valueOf(a*(fact/2)));
                    }
                    else break;
                    
                }
                for (int j=0; j<cnts_of_cnta[cnts_of_cnta.length-i-1];j++){
                    if (elcounter_worsta<a*(fact/2)){
                        elcounter_worsta++;
                        worst_c_avga+=(Double.valueOf(cnts_of_cnta.length-i-1)/Double.valueOf(a*(fact/2)));
                    }
                    else break;
                    
                }


                for (int j=0; j<cnts_of_cntb[i];j++){
                    if (elcounter_bestb<a*(fact/2)){
                        elcounter_bestb++;
                        best_c_avgb+=(Double.valueOf(i)/Double.valueOf(a*(fact/2)));
                    }
                    else break;
                    
                }
                for (int j=0; j<cnts_of_cntb[cnts_of_cntb.length-i-1];j++){
                    if (elcounter_worstb<a*(fact/2)){
                        elcounter_worstb++;
                        worst_c_avgb+=(Double.valueOf(cnts_of_cntb.length-i-1)/Double.valueOf(a*(fact/2)));
                    }
                    else break;
                    
                }
            }
            System.out.println( n+": best a: "+best_c_avga+" best b: "+best_c_avgb+" rel: " +best_c_avga/best_c_avgb);
            System.out.println( n+": worst a: "+worst_c_avga+" worst b: "+worst_c_avgb+" rel: " +worst_c_avga/worst_c_avgb);
            
          

             data[0][nIndex]=Double.valueOf(n);
             data[1][nIndex]=Double.valueOf(a);
             data[2][nIndex]=Double.valueOf(tavga);
             data[3][nIndex]=Double.valueOf(tavgb);
             data[4][nIndex]=Double.valueOf(tavga/tavgb);
             data[5][nIndex]=Double.valueOf(best_c_avga);
             data[6][nIndex]=Double.valueOf(best_c_avgb);
             data[7][nIndex]=Double.valueOf(best_c_avga/best_c_avgb);
             data[8][nIndex]=Double.valueOf(worst_c_avga);
             data[9][nIndex]=Double.valueOf(worst_c_avgb);
             data[10][nIndex]=Double.valueOf(worst_c_avga/worst_c_avgb);
            nIndex++;
            }
       
         
    }
    
   
    
   

   
    

    System.out.println("Done");
        try {
            write_to_excel.main(data);
        } catch (Exception e) {
            System.out.println("err");          }
    }
    
} 
