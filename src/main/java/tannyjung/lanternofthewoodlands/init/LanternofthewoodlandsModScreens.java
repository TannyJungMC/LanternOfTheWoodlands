
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.lanternofthewoodlands.init;

import tannyjung.lanternofthewoodlands.init.LanternofthewoodlandsModMenus.GuiSyncMessage;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIweaponSwordScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIweaponShieldScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIweaponLanternScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIweaponKnightSwordScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIweaponBowScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIweaponAnchorScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIsettingsScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIsettings2Screen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIdetailsScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.Spell4GUI2Screen;
import tannyjung.lanternofthewoodlands.client.gui.Spell1GUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.PersonalWeaponGUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.PersonalWeaponGUI2Screen;
import tannyjung.lanternofthewoodlands.client.gui.PersonalSkillGUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.PersonalSkillGUI2Screen;
import tannyjung.lanternofthewoodlands.client.gui.MenuGUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.ManaRegenerationGUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.LawsOfMagicGUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.GUISpell4Screen;
import tannyjung.lanternofthewoodlands.client.gui.GUIIndexScreen;
import tannyjung.lanternofthewoodlands.client.gui.GUIDescriptionScreen;
import tannyjung.lanternofthewoodlands.client.gui.GUIAdvanceSpellSelectScreen;
import tannyjung.lanternofthewoodlands.client.gui.FromCreatorGUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.AllyListGUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.AllyListGUI2Screen;
import tannyjung.lanternofthewoodlands.client.gui.AgreementGUIScreen;
import tannyjung.lanternofthewoodlands.client.gui.AdvanceSpellGUIScreen;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LanternofthewoodlandsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GUI.get(), Spell4GUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.ALLY_LIST_GUI.get(), AllyListGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.FROM_CREATOR_GUI.get(), FromCreatorGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.PERSONAL_WEAPON_GUI.get(), PersonalWeaponGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.PERSONAL_SKILL_GUI.get(), PersonalSkillGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.PERSONAL_SKILL_GUI_2.get(), PersonalSkillGUI2Screen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.PERSONAL_WEAPON_GUI_2.get(), PersonalWeaponGUI2Screen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.ALLY_LIST_GUI_2.get(), AllyListGUI2Screen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.MANA_REGENERATION_GUI.get(), ManaRegenerationGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.MENU_GUI.get(), MenuGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_IWEAPON_SWORD.get(), Spell4GUIweaponSwordScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.AGREEMENT_GUI.get(), AgreementGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.LAWS_OF_MAGIC_GUI.get(), LawsOfMagicGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GUI_2.get(), Spell4GUI2Screen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.ADVANCE_SPELL_GUI.get(), AdvanceSpellGUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_ISETTINGS.get(), Spell4GUIsettingsScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_IDETAILS.get(), Spell4GUIdetailsScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_IWEAPON_BOW.get(), Spell4GUIweaponBowScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_IWEAPON_LANTERN.get(), Spell4GUIweaponLanternScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_IWEAPON_SHIELD.get(), Spell4GUIweaponShieldScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_IWEAPON_ANCHOR.get(), Spell4GUIweaponAnchorScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_IWEAPON_KNIGHT_SWORD.get(), Spell4GUIweaponKnightSwordScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_4_GU_ISETTINGS_2.get(), Spell4GUIsettings2Screen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.SPELL_1_GUI.get(), Spell1GUIScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.GUI_DESCRIPTION.get(), GUIDescriptionScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.GUI_ADVANCE_SPELL_SELECT.get(), GUIAdvanceSpellSelectScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.GUI_INDEX.get(), GUIIndexScreen::new);
			MenuScreens.register(LanternofthewoodlandsModMenus.GUI_SPELL_4.get(), GUISpell4Screen::new);
		});
	}

	static void handleTextBoxMessage(GuiSyncMessage message) {
		String editbox = message.editbox();
		String value = message.value();
		Screen currentScreen = Minecraft.getInstance().screen;
		if (currentScreen instanceof WidgetScreen sc) {
			HashMap<String, Object> widgets = sc.getWidgets();
			Object obj = widgets.get("text:" + editbox);
			if (obj instanceof EditBox box) {
				box.setValue(value);
			}
		}
	}

	public interface WidgetScreen {
		HashMap<String, Object> getWidgets();
	}
}
