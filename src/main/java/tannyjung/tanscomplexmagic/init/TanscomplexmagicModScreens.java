/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tanscomplexmagic.init;

import tannyjung.tanscomplexmagic.client.gui.*;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class TanscomplexmagicModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(TanscomplexmagicModMenus.SPELL_4_GUI.get(), Spell4GUIScreen::new);
		event.register(TanscomplexmagicModMenus.ALLY_LIST_GUI.get(), AllyListGUIScreen::new);
		event.register(TanscomplexmagicModMenus.FROM_CREATOR_GUI.get(), FromCreatorGUIScreen::new);
		event.register(TanscomplexmagicModMenus.PERSONAL_WEAPON_GUI.get(), PersonalWeaponGUIScreen::new);
		event.register(TanscomplexmagicModMenus.PERSONAL_SKILL_GUI.get(), PersonalSkillGUIScreen::new);
		event.register(TanscomplexmagicModMenus.PERSONAL_SKILL_GUI_2.get(), PersonalSkillGUI2Screen::new);
		event.register(TanscomplexmagicModMenus.PERSONAL_WEAPON_GUI_2.get(), PersonalWeaponGUI2Screen::new);
		event.register(TanscomplexmagicModMenus.ALLY_LIST_GUI_2.get(), AllyListGUI2Screen::new);
		event.register(TanscomplexmagicModMenus.MANA_REGENERATION_GUI.get(), ManaRegenerationGUIScreen::new);
		event.register(TanscomplexmagicModMenus.MENU_GUI.get(), MenuGUIScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_IWEAPON_SWORD.get(), Spell4GUIweaponSwordScreen::new);
		event.register(TanscomplexmagicModMenus.AGREEMENT_GUI.get(), AgreementGUIScreen::new);
		event.register(TanscomplexmagicModMenus.LAWS_OF_MAGIC_GUI.get(), LawsOfMagicGUIScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GUI_2.get(), Spell4GUI2Screen::new);
		event.register(TanscomplexmagicModMenus.ADVANCE_SPELL_GUI.get(), AdvanceSpellGUIScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_ISETTINGS.get(), Spell4GUIsettingsScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_IDETAILS.get(), Spell4GUIdetailsScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_IWEAPON_BOW.get(), Spell4GUIweaponBowScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_IWEAPON_LANTERN.get(), Spell4GUIweaponLanternScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_IWEAPON_SHIELD.get(), Spell4GUIweaponShieldScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_IWEAPON_ANCHOR.get(), Spell4GUIweaponAnchorScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_IWEAPON_KNIGHT_SWORD.get(), Spell4GUIweaponKnightSwordScreen::new);
		event.register(TanscomplexmagicModMenus.SPELL_4_GU_ISETTINGS_2.get(), Spell4GUIsettings2Screen::new);
		event.register(TanscomplexmagicModMenus.SPELL_1_GUI.get(), Spell1GUIScreen::new);
		event.register(TanscomplexmagicModMenus.GUI_DESCRIPTION.get(), GUIDescriptionScreen::new);
		event.register(TanscomplexmagicModMenus.GUI_ADVANCE_SPELL_SELECT.get(), GUIAdvanceSpellSelectScreen::new);
		event.register(TanscomplexmagicModMenus.GUI_INDEX.get(), GUIIndexScreen::new);
		event.register(TanscomplexmagicModMenus.GUI_SPELL_4.get(), GUISpell4Screen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}