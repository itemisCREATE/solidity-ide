import { PluginManager } from '@remixproject/engine';
import { from, Observable, asyncScheduler, scheduled } from 'rxjs';
import { map } from 'rxjs/operators';
import { timeStamp } from 'console';
export class YakinduPluginManager extends PluginManager {

  getActiveProfileNames(): string[] {
    return this.actives.filter((name) => name !== 'manager' && name !== 'fileManager' && name !== 'editor');
  }
}
