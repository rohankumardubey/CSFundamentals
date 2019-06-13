# This method will sort the array in the ascending order using bubble sort algorithm
def sort(array):
    # Finding the length of the array passed
    length = len(array)

    # Outer loop - this will denote each pass. We are taking length - 1 as we are comparing each value
    # with its next value
    for i in range(length - 1):
        # Inner loop - This will run for each pass and will compare each value to its next value
        # We are taking (length-i-1) as the largest element will be at the end of the array,
        # so we need not compare it again.
        for j in range(length - i - 1):
            # Check if the elements are in the wrong order
            if array[j] > array[j + 1]:
                # If they are, then we swap them
                array[j], array[j + 1] = array[j + 1], array[j]

    # Returning the sorted array
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
