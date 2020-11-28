import { TestBed } from '@angular/core/testing';

import { TiposMeiosPagtoService } from './tipos-meios-pagto.service';

describe('TiposMeiosPagtoService', () => {
  let service: TiposMeiosPagtoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TiposMeiosPagtoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
