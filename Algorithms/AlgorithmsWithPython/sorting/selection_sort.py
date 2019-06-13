# This method will sort the array in the ascending order using selection sort algorithm
def sort(array):
    # Length of the array
    length = len(array)

    # Outer loop - for each pass
    for i in range(length):
        # Index of the minimum element
        min_index = i

        # Inner loop - this weill compare the each element with the element at the minimum
        # index and will swap if needed
        for j in range(i + 1, length):
            if array[min_index] > array[j]:
                min_index = j

        # Swap the first element of the unsorted array to the element at the current minimum index
        array[min_index], array[i] = array[i], array[min_index]

    # Return the sorted array
    return array


# Main function to execute the code
def main():
    # Array to be sorted
    array = [4, 5, 7, 1, 3, 9, 8, 2, 6]
    # Print the sorted array
    print(sort(array))


# Code to call the main function
if __name__ == '__main__':
    main()
