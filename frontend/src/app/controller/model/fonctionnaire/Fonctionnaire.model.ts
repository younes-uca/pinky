import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class FonctionnaireDto extends BaseDto{

    public cin: string;

    public nom: string;

    public prenom: string;

    public username: string;

    public mail: string;

   public credentialsNonExpired: null | boolean;

   public enabled: null | boolean;

   public accountNonExpired: null | boolean;

   public accountNonLocked: null | boolean;

   public passwordChanged: null | boolean;

    public username: string;

    public password: string;

    

    constructor() {
        super();

        this.cin = '';
        this.nom = '';
        this.prenom = '';
        this.username = '';
        this.mail = '';
        this.credentialsNonExpired = null;
        this.enabled = null;
        this.accountNonExpired = null;
        this.accountNonLocked = null;
        this.passwordChanged = null;
        this.username = '';
        this.password = '';

        }

}
