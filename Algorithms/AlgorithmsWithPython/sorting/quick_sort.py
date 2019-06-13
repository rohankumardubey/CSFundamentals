def partition(array, start, end):
    i = start - 1

    # Pivot element - last element of the array
    pivot = array[end]

    for j in range(start, end):
        if array[j] <= pivot:
            # Increment i by 1
            i += 1

            # Swap the elements
            array[i], array[j] = array[j], array[i]

    array[i + 1], array[end] = array[end], array[i + 1]

    return i + 1


# This method will sort the array in the ascending order using merge sort algorithm
def quick_sort(array, start, end):
    # Check the base case
    if start < end:
        # Finding the partition index
        partition_index = partition(array, start, end)

        # For the left sub array
        quick_sort(array, start, partition_index - 1)

        # For the right sub array
        quick_sort(array, partition_index + 1, end)

    return array


# Main function to execute the code
def main():
    # Array to be sorted
    array = [4, 5, 7, 1, 3, 9, 8, 2, 6]

    # Start index
    start = 0

    # End index
    end = len(array) - 1

    # Print the sorted array
    print(quick_sort(array, start, end))


# Code to call the main function
if __name__ == '__main__':
    main()
