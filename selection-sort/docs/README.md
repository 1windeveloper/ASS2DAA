# Selection Sort with Early Termination Optimization

This project is part of Assignment 2 in the **Design and Analysis of Algorithms** course. It focuses on implementing the **Selection Sort** algorithm with an early termination optimization. The main goal is to efficiently sort an array while considering performance aspects such as comparisons, swaps, and early termination when the array is already sorted.

## Algorithm Overview

### Selection Sort

Selection Sort is a comparison-based sorting algorithm. It works by repeatedly finding the minimum element from the unsorted portion of the array and swapping it with the first unsorted element. This process is repeated for all elements in the array.

### Early Termination Optimization

In the basic Selection Sort, after each iteration, the algorithm continues to make unnecessary comparisons even when the array is already sorted. The optimization introduced in this implementation checks if any swaps were made during an iteration. If no swaps were made, it breaks out of the loop early, improving performance in nearly-sorted arrays.

## Complexity Analysis

### Time Complexity

- **Best case**: `O(n^2)` - Even with the early termination optimization, the algorithm still has to check all pairs in the worst case (when the array is reverse sorted).
- **Average case**: `O(n^2)` - The algorithm still performs comparisons and swaps on average, resulting in quadratic complexity.
- **Worst case**: `O(n^2)` - This is when the array is reverse sorted, and the algorithm has to go through all iterations and comparisons.

### Space Complexity

- **Auxiliary space**: `O(1)` - Selection Sort is an in-place sorting algorithm, so it requires only a constant amount of extra space.

## Features

- **Early Termination Optimization**: Stops further comparisons once the array is sorted, saving unnecessary operations.
- **Unit Tests**: Comprehensive tests covering edge cases like empty arrays, arrays with a single element, and already sorted arrays.
- **Performance Metrics**: Collection of metrics for comparisons, swaps, and array accesses.

## How to Run

### Clone the Repository

```bash
git clone https://github.com/1windeveloper/ASS2DAA.git
cd ASS2DAA/selection-sort
