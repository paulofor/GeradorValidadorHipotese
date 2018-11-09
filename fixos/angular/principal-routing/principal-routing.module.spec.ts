import { PrincipalRoutingModule } from './principal-routing.module';

describe('PrinicipalRoutingModule', () => {
  let principalRoutingModule: PrincipalRoutingModule;

  beforeEach(() => {
    principalRoutingModule = new PrincipalRoutingModule();
  });

  it('should create an instance', () => {
    expect(principalRoutingModule).toBeTruthy();
  });
});