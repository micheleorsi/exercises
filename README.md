
# ALGORITHMS

- [X] [binary search](src/algo/BinarySearch.java)

## sort

- [ ] heap sort
- [X] [insertion sort](src/algo/sort/InsertionSort.java)
- [X] [merge sort](src/algo/sort/MergeSort.java)
- [X] [quick sort](src/algo/sort/QuickSort.java)
- [X] [selection sort](src/algo/sort/SelectionSort.java)
- [X] [bubble sort](src/algo/sort/BubbleSort.java)
- [ ] distribution sort
- [ ] radix sort
- [ ] shellsort

## linked list

- [ ] search in a linked list
- [ ] insertion in a linked list
- [ ] deletion from a list

## stack

- [ ] push
- [ ] pop

## queue

- [ ] enqueue
- [ ] dequeue

## dictionaries

- [ ] search
- [ ] insert
- [ ] delete
- [ ] max/min
- [ ] predecessor/successor

## binary search tree

- [ ] searching in a tree
- [ ] find min/max in a tree
- [ ] traversal in a tree
- [ ] insertion in a tree
- [ ] deleting from a tree

## priority queues

- [ ] insert
- [ ] find minimum/maximum
- [ ] delete minimum/maximum

## heap

- [ ] build heap
- [ ] extract min (bubble down)
- [ ] heap in an array
- [ ] insert in a heap (bubble up)

## graph

- [ ] traversing a graph
- [ ] bread first search
- [ ] bfs: finding paths
- [ ] bfs: connected component
- [ ] bfs: two-coloring graphs
- [ ] depth first search
- [ ] dps: finding cycles
- [ ] dps: articulation vertices
- [ ] depth first search on directed graphs
- [ ] topological sorting
- [ ] strongly connected components
- [ ] topological sorting

### minimum spanning trees

- [ ] prim's algorithm
- [ ] Kruskal's Algorithm
- [ ] Union-Find Data Structure
- [ ] maximum spanning tree
- [ ] minimum product spanning tree
- [ ] minimum bottleneck spanning tree
- [ ] steiner tree
- [ ] low-degree Spanning Tree

### shortest paths

- [ ] Dijkstra's Algorithm
- [ ] all-pairs shortest path
- [ ] transitive closure

### network flows and bipartite matching

- [ ] bipartite matching
- [ ] computing network flows

## backtracking

- [X] [subsets](src/algo/SubsetAlgo.java)
- [ ] permutations
- [ ] combination sum
- [ ] palindrome partitioning
- [ ] anagram of a string
- [ ] all paths in a graph
- [ ] sudoku

## heuristic

- [ ] random sampling
- [ ] local search
- [ ] simulated annealing
- [ ] simulated annealing: maximum cut
- [ ] simulated annealing: independent set
- [ ] simulated annealing: circuit board placement
- [ ] genetic algorithm

## dynamic programming

- [X] [knapsack problem](src/algo/dynamicprogramming/Knapsack.java)

## randomized algo

- [X] [reservoir sampling](src/algo/randomized/ReservoirSampling.java)

# PROBLEMS

## chap 1

- [ ] robot tour optimization
- [ ] movie scheduling problem
- [ ] set covering

## chap 2: algo analysis

- [ ] string pattern matching
- [X] [matrix multiplication](src/algo/MatrixMultiplication.java)
- [X] [fast exponentiation](src/algo/FastExponentiation.java)

## chap 3: data structure

- [ ] string pattern matching (with hash)

## chap 4: sorting and searching

- [X] searching an item in an ordered list O(log n)
- [X] closest pair - given a set of n numbers, how do you find the pair of numbers that have the smallest difference between them? O(n log n)
- [X] element uniqueness: Are there any duplicates in a given set of n items? O(n log n)
- [X] frequency distribution - given a set of n items, which element occurs the largest number of times in the set? If the items are sorted, we can sweep from left to right and count them, since all identical items will be lumped together during sorting.
- [X] selection - what is the kth largest item in an array?
- [ ] finding intersection: give an efficient algorithm to determine whether two sets (of size m and n, respectively) are disjoint 
- [ ] the nuts and bolts problem - You are given a collection of n bolts of different widths, and n corresponding nuts. You can test whether a given nut and bolt fit together, from which you learn whether the nut is too large, too small, or an exact match for the bolt. The differences in size between pairs of nuts or bolts are too small to see by eye, so you cannot compare the sizes of two nuts or two bolts directly. You are to match each bolt to each nut. 
- [ ] counting occurencies: count the number of times a given key k occurs in a given sorted array 
- [ ] one side binary search: now suppose we have an array A consisting of a run of 0's, followed by an unbounded run of 1's, and would like to identify the exact point of transition between them
- [ ] find square root and other roots

## chap 5: graph traversal

- [ ] adjacency matrix
- [ ] adjacency list
- [ ] read graph from a file

## chap 6: weighted graph algorithms

- [ ] I'm looking for an algorithm to design natural routes for video-game characters to follow through an obstacle-filled room. How should I do it
- [ ] a DNA sequencing project generates experimental data consisting of small fragments. For each given fragment f, we know certain other fragments are forced to lie to the left of f, and certain other fragments are forced to be to the right of f. How can we find a consistent ordering of the fragments from left to right that satisfies all the constraints? 
- [ ] in my graphics work I need to solve the following problem. Given an arbitrary set of rectangles in the plane, how can I distribute them into a minimum number of buckets such that no subset of rectangles in any given bucket intersects another? In other words, there can not be any overlapping area between two rectangles in the same bucket
- [ ] in porting code from UNIX to DOS, I have to shorten several hundred file names down to at most 8 characters each. I can't just use the first eight characters from each name, because "filenamel" and "filename2" would be assigned the exact same name. How can I meaningfully shorten the names while ensuring that they do not collide?
- [ ] we need a way to separate the lines of text in the optical characterrecognition system that we are building. Although there is some white space between the lines, problems like noise and the tilt of the page makes it hard to find. How can we do line segmentation?

## chap 7: combinatorial search and heuristic methods

- [ ] covering chessboard

## chap 8: dynamic programming

- [ ] fibonacci numbers 
- [ ] binomial coefficient
- [ ] approximate string matching
- [ ] the partition problem
- [ ] parsing context free grammars

## chap 9: intractable problems and approximation algorithms

- [ ] traveling Salesman Problem
- [ ] closest pair
- [ ] longest increasing subsequence
- [ ] least common multiple
- [ ] convex hull
- [ ] hamiltonian cycle
- [ ] independent set and vertex cover
- [ ] general movie scheduling decision problem
- [ ] clique
- [ ] satisfiability
- [ ] integer programming
- [ ] vertex cover
- [ ] approximate vertex cover
- [ ] the euclidean traveling salesman
- [ ] Maximum Acyclic Subgraph
- [ ] set cover

# THEOREM
- [ ] 1 + 2 + 3 + 4 .. n = n(n+1)/2
- [ ] (n-1) + (n-2) + (n-3) + .. + 2 + 1 = n(n-1)/2
- [ ] 1 + 1/2 + 1/4 + 1/8 .. = ln n (< 2) (harmonic number) 
- [ ] f(n) = O(g(n)) -> c such that f(n) is always < c * g(n), for large enough n
- [ ] f(n) = Teta(g(n)) -> c1 and c2 such that f(n) is always > c2 * g(n) and < c1 * g(n), for large enough n
- [ ] f(n) = Sigma(g(n)) -> c such that f(n) is always > c * g(n), for large enough n
- [ ] log<sub>a</sub> (x*y) = log<sub>a</sub> x + log<sub>a</sub> y
- [ ] log<sub>a</sub> n<sup>b</sup> = b * log<sub>a</sub> n, a<sup>b</sup> = exp(ln(a<sup>b</sup>)) = exp(b * ln a)
- [ ] log<sub>a</sub> b = log<sub>c</sub> b / log<sub>c</sub> a
- [ ] polynomial recurrence: An = n -> An = An-1 +1, A1 = 1
- [ ] exponential recurrence: An = 2<sup>(n-1)</sup> -> An = 2An-1, A1 = 1
- [ ] factorial recurrence: An = n! -> An = nAn-1, A1 = 1
- [ ] master algorithm - T(n) = aT(n/b) + f(n), depending on f(n)

# INTERVIEW QUESTIONS

## chap 1

- [X] [integer division without using either the / or * operators](src/problems/IntegerDivision.java)
- [X] on average, how many times would you have to flip open the Manhattan phone book at random in order to find a specific name?
- [ ] Implement the two TSP heuristics of Section 1.1 (page 5). Which of them gives better-quality solutions in practice? Can you devise a heuristic that works better than both of them'?

## chap 2: algo analysis

- [ ] you are given a set S of n numbers. You must pick a subset S' of k numbers from S such that the probability of each element of S occurring in S' is equal (i.e., each is selected with probability k/n). You may make only one pass over the numbers. What if n is unknown? 
- [ ] we have 1,000 data items to store on 1,000 nodes. Each node can store copies of exactly three different items. Propose a replication scheme to minimize data loss as nodes fail. What is the expected number of data entries that get lost when three random nodes fail?
- [ ] consider the following algorithm to find the minimum element in an array of numbers A[0,...,n]. One extra variable tmp is allocated to hold the current minimum value. Start from A[0]; "tmp" is compared against A[l], A[2], ..., A[N] in order. When A[i] < trop, trop = A[i]. What is the expected number of times that the assignment operation tmp = A[i] is performed?
- [ ] you have a 100-story building and a couple of marbles. You must identify the lowest floor for which a marble will break if you drop it from this floor. How fast can you find this floor if you are given an infinite supply of marbles'? What if you have only two marbles?
- [ ] you are given 10 bags of gold coins. Nine bags contain coins that each weigh 10 grams. One bag contains all false coins that weigh one gram less. You must identify this bag in just one weighing. You have a digital balance that reports the weight of what is placed on it. 
- [ ] you have eight balls all of the same size. Seven of them weigh the same, and one of them weighs slightly more. How can you find the ball that is heavier by using a balance and only two weighings?
- [ ] suppose we start with n companies that eventually merge into one big company. How many different ways are there for them to merge
- [ ] a Ramanujan-Hardy number can be written two different ways as the sum of two cubesi.e., there exist distinct a, b, c, and d such that a3 + b3 = c3 + d3. Generate all Ramanujam numbers where a, b, c, d < n
- [ ] six pirates must divide $300 dollars among themselves. The division is to proceed as follows. The senior pirate proposes a way to divide the money. Then the pirates vote. If the senior pirate gets at least half the votes he wins, and that division remains. If he doesn't, he is killed and then the next senior-most pirate gets a chance to do the division. Now you have to tell what will happen and why (i.e., how many pirates survive and how the division is done)? All the pirates are intelligent and the first priority is to stay alive and the next priority is to get as much money as possible.
- [ ] reconsider the pirate problem above, where only one indivisible dollar is to be divided. Who gets the dollar and how many are killed? 

## chap 3: data structure

- [ ] what method would you use to look up a word in a dictionary?
- [ ] imagine you have a closet full of shirts. What can you do to organize your shirts for easy retrieval?
- [ ] write a function to find the middle node of a singly-linked list.
- [ ] write a function to compare whether two binary trees are identical. Identical trees have the same key value at each position and the same structure.
- [ ] write a program to convert a binary search tree into a linked list.
- [ ] implement an algorithm to reverse a linked list. Now do it without recursion.
- [ ] what is the best data structure for maintaining URLs that have been visited by a Web crawler'? Give an algorithm to test whether a given URL has already been visited, optimizing both space and time.
- [ ] you are given a search string and a magazine. You seek to generate all the characters in search string by cutting them out from the magazine. Give an algorithm to efficiently determine whether the magazine contains all the letters in the search string.
- [ ] reverse the words in a sentence i.e., "My name is Chris" becomes "Chris is name My." Optimize for time and space.
- [ ] determine whether a linked list contains a loop as quickly as possible without using any extra storage. Also, identify the location of the loop.
- [ ] you have an unordered array X of n integers. Find the array M containing n elements where Xi is the product of all integers in X except for Xi. You may not use division. You can use extra memory. (Hint: There are solutions faster than O(n2).)
- [ ] give an algorithm for finding an ordered word pair (e.g., "New York") occurring with the greatest frequency in a given webpage. Which data structures would you use? Optimize both time and space.

## chap 4: sorting and searching

- [ ] if you are given a million integers to sort, what algorithm would you use to sort them? How much time and memory would that consume?
- [ ] describe advantages and disadvantages of the most popular sorting algorithms.
- [ ] implement an algorithm that takes an input array and returns only the unique elements in it.
- [ ] you have a computer with only 2Mb of main memory. How do you use it to sort a large file of 500 Mb that is on disk?
- [ ] design a stack that supports push, pop, and retrieving the minimum element in constant time. Can you do this?
- [ ] given a search string of three words, find the smallest snippet of the document that contains all three of the search wordsi.e., the snippet with smallest number of words in it. You are given the index positions where these words occur in the document, such as wordl: (1, 4, 5), word2: (3, 9, 10), and word3: (2, 6, 15). Each of the lists are in sorted order, as above.
- [ ] you are given 12 coins. One of them is heavier or lighter than the rest. Identify this coin in just three weighings

## chap 5: graph traversal

- [ ] which data structures are used in depth-first and breath-first search?

## chap 7: weighted graph algorithms

- [ ] write a function to find all permutations of the letters in a particular string.
- [ ] implement an efficient algorithm for listing all k-element subsets of n items.
- [ ] an anagram is a rearrangement of the letters in a given string into a sequence of dictionary words, like Steven Skiena into Vainest Knees. Propose an algorithm to construct all the anagrams of a given string.
- [ ] telephone keypads have letters on each numerical key. Write a program that generates all possible words resulting from translating a given digit sequence (e.g., 145345) into letters.
- [ ] you start with an empty room and a group of n people waiting outside. At each step, you may either admit one person into the room, or let one out. Can you arrange a sequence of 2' steps, so that every possible combination of people is achieved exactly once?
- [ ] use a random number generator (rng04) that generates numbers from {0, 1, 2, 3,41 with equal probability to write a random number generator that generates numbers from 0 to 7 (rng07) with equal probability. What are expected number of calls to rng04 per call of rng07?”
      
## chap 8: dynamic programming

- [ ] given a set of coin denominators, find the minimum number of coins to make a certain amount of change.
- [ ] you are given an array of n numbers, each of which may be positive, negative, or zero. Give an efficient algorithm to identify the index positions i and j to the maximum sum of the ith through jth numbers.
- [ ] observe that when you cut a character out of a magazine, the character on the reverse side of the page is also removed. Give an algorithm to determine whether you can generate a given string by pasting cutouts from a given magazine. Assume that you are given a function that will identify the character and its position on the reverse side of the page for any given character position