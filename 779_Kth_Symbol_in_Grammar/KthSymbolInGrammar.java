class KthSymbolInGrammar {

    public int kthGrammar(int N, int K) {
        // if (N == 1) {
        //     return 0;
        // }
        // if (K % 2 == 0) {
        //     return 1 - kthGrammar(N - 1, (K + 1) / 2);
        // } else {
        //     return kthGrammar(N - 1, (K + 1) / 2);
        // }
        return N == 1 ? 0 : K % 2 == 0 ? 1 - kthGrammar(N - 1, (K + 1) / 2) : kthGrammar(N - 1, (K + 1) / 2);
    }
}
