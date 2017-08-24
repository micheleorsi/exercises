package algo.backtracking;

public class Backtrack {

    boolean finished=false;

    boolean isASolution(int[] a, int k, int n) {
        return k==n;
    }

    void backtrack(int a[], int k, int input) {
        int ncandidates=10;
        int[] c = new int[10];

        if(isASolution(a,k,input)) {
            processSolution(a,k,input);
        } else {
            k=k+1;
            constructCandidate(a,k,input);
            for(int i=0; i<ncandidates; i++) {
                a[k]=c[i];
                makeMove(a,k,input);
                backtrack(a,k,input);
                unmakeMove(a,k,input);
                if(finished)
                    return;
            }
        }
    }

    void unmakeMove(int[] a, int k, int input) {

    }

    void makeMove(int[] a, int k, int input) {

    }

    void constructCandidate(int[] a, int k, int input) {

    }

    void processSolution(int[] a, int k, int input) {

    }

}
