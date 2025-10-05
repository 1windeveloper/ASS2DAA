# ASS2DAA - Selection Sort Algorithm

## Project Description

This project implements the **Selection Sort** algorithm with early termination optimization as part of the **Algorithmic Analysis and Peer Code Review** assignment. The algorithm is implemented in **Java**, and unit tests have been written using **JUnit**.

**Selection Sort** is a simple sorting algorithm that works by repeatedly finding the minimum element and swapping it with the current position. In this implementation, an optimization is added: if no swaps are made during a pass, the algorithm terminates early, which saves time when dealing with partially sorted arrays.

## Setup Instructions

1. **Clone the repository:**

    ```bash
    git clone https://github.com/1windeveloper/ASS2DAA.git
    cd ASS2DAA
    ```

2. **Install Maven and Java:**

    Ensure that **Maven** (version 3.6 or later) and **Java** (version 8 or later) are installed on your machine.

    To install Maven and Java, follow the official documentation:
    - [Maven Installation](https://maven.apache.org/install.html)
    - [Java Installation](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

3. **Build the project with Maven:**

    Run the following command in your terminal to build the project:

    ```bash
    mvn clean install
    ```

4. **Run the tests:**

    After building the project, run the tests with:

    ```bash
    mvn test
    ```

    All tests should pass successfully, confirming that the algorithm works correctly.

## Algorithm Analysis

### Description

The **Selection Sort** algorithm works by iterating through the array and finding the minimum element. This element is then swapped with the first element, and the process is repeated for the remaining unsorted portion of the array.

**Early Termination Optimization**: If no swaps are made during a pass through the array, it means the array is already sorted, and the algorithm terminates early.

### Time Complexity

1. **Best Case (O(n))**: When the array is already sorted. The algorithm will terminate after the first pass.
2. **Worst and Average Case (O(n²))**: When the array is unsorted or in reverse order.

The algorithm works **in-place**, meaning it doesn't require extra memory except for temporary variables used to store indices.

### Advantages

- Simple to implement.
- Works well for small arrays or nearly sorted data.

### Disadvantages

- Inefficient for large arrays due to its quadratic time complexity.

## Repository Structure
assignment2-selection-sort/
├── src/main/java/
│   └── algorithms/SelectionSort.java
├── src/test/java/
│   └── algorithms/SelectionSortTest.java
├── docs/
│   └── analysis-report.pdf
├── README.md
└── pom.xml
## License

This project was developed as part of an educational course and is provided for educational purposes.
