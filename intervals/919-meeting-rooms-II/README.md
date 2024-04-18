<h2><a href="https://www.lintcode.com/problem/919/">Meeting Rooms II</a></h2> <img src='https://img.shields.io/badge/Difficulty-Medium-orange' alt='Difficulty: Medium' /><hr>

## Description
Given an array of meeting time intervals consisting of start and end times `[[s1,e1],[s2,e2],...] (si < ei)`, find the minimum number of conference rooms required.

`(0,8),(8,10)` is not conflict at `8`

## Example

### Example1

Input: intervals = `[(0,30),(5,10),(15,20)]` <br>
Output: `2` <br>
Explanation:
We need two meeting rooms
```
room1: (0,30)
room2: (5,10),(15,20)
```

### Example2

Input: intervals = `[(2,7)]` <br>
Output: `1` <br>
Explanation: 
Only need one meeting room


