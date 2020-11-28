import { TestBed } from '@angular/core/testing';

import { ConfiguracoesPtBrService } from './configuracoes-pt-br.service';

describe('ConfiguracoesPtBrService', () => {
  let service: ConfiguracoesPtBrService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConfiguracoesPtBrService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
