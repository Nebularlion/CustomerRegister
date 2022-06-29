import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Company } from '../models/company';

@Injectable()
export class CompanyService {
  private companyUrl: string;
  constructor(private http: HttpClient) {
    this.companyUrl = 'http://localhost:8080';
  }

  public findAllCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(this.companyUrl + '/companies');
  }
}
