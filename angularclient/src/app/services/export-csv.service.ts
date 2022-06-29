import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class ExportCsvService {
  private fileUrl: string;
  constructor(private http: HttpClient) {
    this.fileUrl = 'http://localhost:8080/exportcsv';
  }

  public exportCsv(): void {
    window.open(this.fileUrl);
  }
}
