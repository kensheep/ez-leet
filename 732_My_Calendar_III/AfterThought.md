My thought process to convert this problem as a problem I'm comfortable with:
We have an integer axis. Every time we book [start, end), we increment every entry in the interval by 1, and what we
are trying to get is to check what's the largest number in the axis.
I just tolerate the fact that the max of the axis is 10^9 (which translates to every read to be 9log(10)).

Good:
I modeled the problem correctly (i.e. timeline, treat start & end as 1 and -1 to denote the interval).

Bad:
I "brutal-forced" my way to use the BIT solution when it obviously has significant runtime as well as memory flaw.
