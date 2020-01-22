insert into ascendancy_activegem_count_asc
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Ascendant' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname ;

insert into ascendancy_activegem_count_ass
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Assassin' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_ber
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Berserker' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_cha
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Champion' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_chi
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Chieftain' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_dea
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Deadeye' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_ele
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Elementalist' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_gla
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Gladiator' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_gua
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Guardian' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_inq
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Inquisitor' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_nec
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Necromancer' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_occ
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Occultist' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_pat
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Pathfinder' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_rai
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Raider' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_sab
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Saboteur' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_sla
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Slayer' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_tri
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Trickster' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;


insert into ascendancy_activegem_count_hie
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Hierophant' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_activegem_count_jug
select labyrinthladderdate,gemname,count(gemname)
from using_activegem
where ascendancy='Juggernaut' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;


