class PushDominoes {
    public String pushDominoes(String dominoes) {
        int prev = 0, curr = 0;
        char[] forces = dominoes.toCharArray();
        for (; curr < forces.length; ++curr) {
            if (forces[curr] == 'L') {
                Arrays.fill(forces, prev, curr, 'L');
                prev = curr;
                break;
            } else if (forces[curr] == 'R') {
                prev = curr;
                break;
            }
        }
        for (; curr < forces.length; ++curr) {
            if (forces[curr] == '.') continue;
            if (forces[curr] == 'L') {
                if (forces[prev] == 'L') Arrays.fill(forces, prev, curr, 'L');
                else if (forces[prev] == 'R') {
                    int midLeft = prev + (curr - prev + 1) / 2;
                    int midRight = prev + (curr - prev) / 2 + 1;
                    Arrays.fill(forces, prev, midLeft, forces[prev]);
                    Arrays.fill(forces, midRight, curr, forces[curr]);
                }
            } else if (forces[curr] == 'R' && forces[prev] == 'R') {
                Arrays.fill(forces, prev, curr, 'R');
            }
            prev = curr;
        }
        if (prev < forces.length && forces[prev] == 'R') Arrays.fill(forces, prev, forces.length, 'R');
        return new String(forces);
    }
}
