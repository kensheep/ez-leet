Nothing much, very typical traversal problem, one can use either BFS or DFS to solve this kind of problem. I personally find recursive DFS to be easier to code.
The idea is to keep track of current level, if current level equals desired level - 1, insert the new nodes as children.
