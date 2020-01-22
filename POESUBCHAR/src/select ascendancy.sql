	select row_number() over (order by sum(gemcount) desc) as num,gemname, sum(gemcount) as count
			from ascendancy_activegem_count_asc
			where  labyrinthladderdate between ( (select max(labyrinthladderdate)
			from labyrinthladder)- INTERVAL 7 DAY)  and(select max(labyrinthladderdate)
			from labyrinthladder)
            group by gemname
            order by sum(gemcount) desc;