import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {FonctionnaireAdminService} from 'src/app/controller/service/admin/fonctionnaire/FonctionnaireAdmin.service';
import {FonctionnaireDto} from 'src/app/controller/model/fonctionnaire/Fonctionnaire.model';
import {FonctionnaireCriteria} from 'src/app/controller/criteria/fonctionnaire/FonctionnaireCriteria.model';

@Component({
  selector: 'app-fonctionnaire-view-admin',
  templateUrl: './fonctionnaire-view-admin.component.html'
})
export class FonctionnaireViewAdminComponent extends AbstractViewController<FonctionnaireDto, FonctionnaireCriteria, FonctionnaireAdminService> implements OnInit {


    constructor(private fonctionnaireService: FonctionnaireAdminService){
        super(fonctionnaireService);
    }

    ngOnInit(): void {
    }




}
