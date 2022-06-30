import { Injectable } from '@angular/core';

@Injectable()
export class ExportCsvService {
  private fileUrl: string;
  constructor() {
    this.fileUrl = 'http://localhost:8080/exportcsv';
  }

  public exportCsv(): void {
    window.open(this.fileUrl);
  }
}
