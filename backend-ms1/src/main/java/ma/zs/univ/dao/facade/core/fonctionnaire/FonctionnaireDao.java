package ma.zs.univ.dao.facade.core.fonctionnaire;

import org.springframework.data.jpa.repository.Query;
import ma.zs.univ.zynerator.repository.AbstractRepository;
import ma.zs.univ.bean.core.fonctionnaire.Fonctionnaire;
import org.springframework.stereotype.Repository;
import ma.zs.univ.bean.core.fonctionnaire.Fonctionnaire;
import java.util.List;


@Repository
public interface FonctionnaireDao extends AbstractRepository<Fonctionnaire,Long>  {
    Fonctionnaire findByCin(String cin);
    int deleteByCin(String cin);

    Fonctionnaire findByUsername(String username);

    @Query("SELECT NEW Fonctionnaire(item.id,item.prenom) FROM Fonctionnaire item")
    List<Fonctionnaire> findAllOptimized();

}
