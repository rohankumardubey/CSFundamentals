# This function will merge the two sub arrays recursively
def merge(left, right, array):
    # Index for the left sub array
    i = 0

    # Index for the right sub array
    j = 0

    # Index for the original array
    k = 0

    # This loop will run for the left and the right sub arrays and merge them after sorting their individual elements
    # This will make the elements to be placed in the correct order
    while i < len(left) and j < len(right):

        # if the current element of the left sub array than the right one, we put the left array's element in the
        # original array, else the right element
        if left[i] < right[j]:
            array[k] = left[i]
            i = i + 1
        else:
            array[k] = right[j]
            j = j + 1

        # Increment the array counter by one - At this we have decided the correct position
        k = k + 1

    # Loop for remaining elements in the left sub array
    while i < len(left):
        array[k] = left[i]
        i = i + 1
        k = k + 1

    # Loop for remaining elements in the right sub array
    while j < len(right):
        array[k] = right[j]
        j = j + 1
        k = k + 1


# This method will sort the array in the ascending order using merge sort algorithm
def merge_sort(array):
    # Length of the array
    length = len(array)

    # Base condition to check if the array has only one element
    if length < 2:
        return array

    # Mid element of the array
    mid = length // 2

    # Left sub array
    left = []

    # Right sub array
    right = []

    # First half of the original array to be pushed in the left array
    for i in range(mid):
        left.append(array[i])
    # Second half of the original array to be pushed in the right array
    for i in range(mid, length):
        right.append(array[i])

    # Recursive calls to further break the array
    merge_sort(left)
    merge_sort(right)

    # After the array is broken completely, we will merge it based on sorted elements
    merge(left, right, array)

    # Return the sorted array
    return array


# Main function to execute the code
def main():
    # Array to be sorted
    array = [4, 5, 7, 1, 3, 9, 8, 2, 6]
    # Print the sorted array
    print(merge_sort(array))


# Code to call the main function
if __name__ == '__main__':
    main()
