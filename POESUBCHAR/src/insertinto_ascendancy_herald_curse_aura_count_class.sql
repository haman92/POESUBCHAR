insert into ascendancy_herald_curse_aura_count_asc
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Ascendant' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname ;

insert into ascendancy_herald_curse_aura_count_ass
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Assassin' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_ber
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Berserker' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_cha
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Champion' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_chi
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Chieftain' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_dea
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Deadeye' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_ele
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Elementalist' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_gla
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Gladiator' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_gua
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Guardian' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_inq
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Inquisitor' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_nec
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Necromancer' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_occ
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Occultist' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_pat
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Pathfinder' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_rai
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Raider' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_sab
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Saboteur' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_sla
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Slayer' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

insert into ascendancy_herald_curse_aura_count_tri
select labyrinthladderdate,gemname,count(gemname)
from using_herald_curse_aura
where ascendancy='Trickster' and labyrinthladderdate = (select labyrinthladderdate from labyrinthladder order by labyrinthladderdate desc Limit 1)
group by labyrinthladderdate, ascendancy,gemname;

