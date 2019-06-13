# This method will sort the array in the ascending order using selection sort algorithm
def sort(array):
    # Length of the array
    length = len(array)

    for i in range(1, length):
        # Key element which needs to be compared
        key = array[i]

        # Move elements of array[0...i-1], that are greater than the key,
        # to one position ahead of their current position
        j = i - 1

        # Loop until we find an element greater than the key
        while j >= 0 and key < array[j]:
            # Insert the jth element to its correct position
            array[j + 1] = array[j]
            # Decrementing j by one
            j -= 1

        # Replace the moved element with the key
        array[j + 1] = key

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
