'''

The planned daily departure times of the buses are listed in an orderly manner
'departure_times', given the current time 'current_time', find how many minutes 
ago the last bus departed. The time format is a string HH:MM, the time range does 
not exceed 24 hours. 
An example  departure_times = [12:30, 14:00, 19:55],  
            current_time =14:30,  
        then solution = 30 minutes. 

Secondly, in the boundary case where departure_times[i] = current_time, we thought 
this bus had not left, so we had to look back at the earlier bus. If the bus has not 
departed, return "-1." 

'''
def convert_to_mins(times):
    minutes = [int(h) * 60 + int(m) for t in times for h, m in [t.split(":")]]
    return minutes

def last_departure(departure_times, current_time):
    minutes = convert_to_mins(departure_times)
    minutes.sort()
    h = current_time.split(":")[0]
    m = current_time.split(":")[1]
    current = int(h) * 60 + int(m)
    left = 0
    right = len(departure_times)
    while left < right:
        mid = (left + right) // 2
        if minutes[mid] < current:
            left = mid + 1
        else:
            right = mid
    if left == 0:
        return -1
    else:
        return current - minutes[left - 1]
