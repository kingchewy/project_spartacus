import { TestBed } from '@angular/core/testing';

import { NightFightService } from './night-fight.service';

describe('NightFightService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: NightFightService = TestBed.get(NightFightService);
    expect(service).toBeTruthy();
  });
});
