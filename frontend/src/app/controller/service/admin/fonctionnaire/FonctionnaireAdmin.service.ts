import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import {environment} from 'src/environments/environment';

import {FonctionnaireDto} from 'src/app/controller/model/fonctionnaire/Fonctionnaire.model';
import {FonctionnaireCriteria} from 'src/app/controller/criteria/fonctionnaire/FonctionnaireCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class FonctionnaireAdminService extends AbstractService<FonctionnaireDto, FonctionnaireCriteria> {
     constructor(private http: HttpClient) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/fonctionnaire/');
    }

    public constrcutDto(): FonctionnaireDto {
        return new FonctionnaireDto();
    }

    public constrcutCriteria(): FonctionnaireCriteria {
        return new FonctionnaireCriteria();
    }
}
