# Improved-QuickSort-Algorithm

In this project I improved the quick-sort algorithm by changing the partition function so it chooses a pivot that is median of three (start, middle and end of a specific iteration) and changing their location in the array instead of taking the last/first element each time.
Then I compared between the two algorithms taking inputs that are all of the possible permutations [1,..,N] of an array of size N.
The number of comparisons saved in a new array by index (for example if we got 5 comparisons in sorting an array using the new algorithm we add 1 to the value in the index number 5 so we get [0,0,0,0,0,1,...] and so on) in this way we can handle a large number of comparisons, for example if we compare for an array of the size 13 we have 13! (6227020800) different possibilities what makes saving them into one array not efficient.
then the results are saved into an excel file. 
