/**
 * @Author rongbin.xie
 * @Description:
 * @Date: Created at 12:41 2018/5/10.
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * <p>
 * <paragraph>
 * Explain
 * memento design pattern, named as snapshot pattern, is one of behavior pattern.Back up the original status of some object to make sure
 * you can revert the status to the special time.
 * <p>
 * Scene
 * This is commonly used in game programming, you can reload your previous version.
 * <p>
 * Roles
 * There are three roles: originator(Noted),memento(Note), careTaker(note App-manager)
 * <p>
 * originator: who create the basic status to be noted
 * memento: role to backup the status data to provide to revert
 * careTaker: role to take care of the mementos
 * </paragraph>
 */
package tranditional.memento;

