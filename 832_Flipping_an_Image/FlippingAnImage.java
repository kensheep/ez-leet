class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return A;
        int M = A.length, N = A[0].length;
        int[][] B = new int[M][N];
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < N; ++j) {
                B[i][j] = 1 - A[i][N - 1 - j];
            }
        }
        return B;
    }
}
