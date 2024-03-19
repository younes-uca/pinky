import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class FonctionnaireCriteria  extends BaseCriteria  {

    public cin: string;
    public cinLike: string;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
    public username: string;
    public usernameLike: string;
    public mail: string;
    public mailLike: string;
    public credentialsNonExpired: null | boolean;
    public enabled: null | boolean;
    public accountNonExpired: null | boolean;
    public accountNonLocked: null | boolean;
    public passwordChanged: null | boolean;
    public username: string;
    public usernameLike: string;
    public password: string;
    public passwordLike: string;

}
