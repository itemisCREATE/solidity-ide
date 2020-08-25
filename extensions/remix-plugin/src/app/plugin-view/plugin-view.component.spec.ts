import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PluginViewComponent } from './plugin-view.component';

describe('PluginViewComponent', () => {
  let component: PluginViewComponent;
  let fixture: ComponentFixture<PluginViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PluginViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PluginViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
