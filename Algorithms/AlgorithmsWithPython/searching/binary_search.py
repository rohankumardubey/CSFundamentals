def binary_search(array, key):
    # Start index
    start = 0

    # End index
    end = len(array) - 1

    # Loop until we reach to the end of the loop
    while start <= end:
        # Middle element of the array
        mid = start + (end - start) // 2

        # If the key is less than the middle element of the array
        if array[mid] < key:
            # Increment the start counter
            start = mid + 1
        # If the key is more than the middle element of the array
        elif array[mid] > key:
            # Decrement the end counter
            end = mid - 1
        else:
            # The code will come here if we have zeroed in to the key
            return "Key {} is present at index {}".format(key, mid)

    return "Key {} is not in the array".format(key)


# Main function to execute the code
def main():
    # Array to be searched
    array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]

    # Element to be searched in the array
    key = 8

    print(binary_search(array, key))


# Code to call the main function
if __name__ == '__main__':
    main()
