
set FOREIGN_KEY_CHECKs = 0;



delete
from ascendancy_activegem_count;

delete
from ascendancy_herald_curse_aura_count;

delete
from ascendancy_uniqueitem_count;


insert into ascendancy_activegem_count
select labyrinthladderdate,ascendancy,gemname,count(gemname)
from using_activegem
group by labyrinthladderdate, using_activegem.ascendancy,gemname ;


insert into ascendancy_herald_curse_aura_count
select labyrinthladderdate,ascendancy,gemname,count(gemname)
from using_herald_curse_aura
group by labyrinthladderdate, ascendancy,gemname ;

set FOREIGN_KEY_CHECKs =1;


