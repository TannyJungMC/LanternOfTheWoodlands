/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.tanscomplexmagic.init;

import tannyjung.tanscomplexmagic.world.inventory.*;
import tannyjung.tanscomplexmagic.network.MenuStateUpdateMessage;
import tannyjung.tanscomplexmagic.TanscomplexmagicMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class TanscomplexmagicModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, TanscomplexmagicMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIMenu>> SPELL_4_GUI = REGISTRY.register("spell_4_gui", () -> IMenuTypeExtension.create(Spell4GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AllyListGUIMenu>> ALLY_LIST_GUI = REGISTRY.register("ally_list_gui", () -> IMenuTypeExtension.create(AllyListGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FromCreatorGUIMenu>> FROM_CREATOR_GUI = REGISTRY.register("from_creator_gui", () -> IMenuTypeExtension.create(FromCreatorGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PersonalWeaponGUIMenu>> PERSONAL_WEAPON_GUI = REGISTRY.register("personal_weapon_gui", () -> IMenuTypeExtension.create(PersonalWeaponGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PersonalSkillGUIMenu>> PERSONAL_SKILL_GUI = REGISTRY.register("personal_skill_gui", () -> IMenuTypeExtension.create(PersonalSkillGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PersonalSkillGUI2Menu>> PERSONAL_SKILL_GUI_2 = REGISTRY.register("personal_skill_gui_2", () -> IMenuTypeExtension.create(PersonalSkillGUI2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PersonalWeaponGUI2Menu>> PERSONAL_WEAPON_GUI_2 = REGISTRY.register("personal_weapon_gui_2", () -> IMenuTypeExtension.create(PersonalWeaponGUI2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AllyListGUI2Menu>> ALLY_LIST_GUI_2 = REGISTRY.register("ally_list_gui_2", () -> IMenuTypeExtension.create(AllyListGUI2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ManaRegenerationGUIMenu>> MANA_REGENERATION_GUI = REGISTRY.register("mana_regeneration_gui", () -> IMenuTypeExtension.create(ManaRegenerationGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MenuGUIMenu>> MENU_GUI = REGISTRY.register("menu_gui", () -> IMenuTypeExtension.create(MenuGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIweaponSwordMenu>> SPELL_4_GU_IWEAPON_SWORD = REGISTRY.register("spell_4_gu_iweapon_sword", () -> IMenuTypeExtension.create(Spell4GUIweaponSwordMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AgreementGUIMenu>> AGREEMENT_GUI = REGISTRY.register("agreement_gui", () -> IMenuTypeExtension.create(AgreementGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LawsOfMagicGUIMenu>> LAWS_OF_MAGIC_GUI = REGISTRY.register("laws_of_magic_gui", () -> IMenuTypeExtension.create(LawsOfMagicGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUI2Menu>> SPELL_4_GUI_2 = REGISTRY.register("spell_4_gui_2", () -> IMenuTypeExtension.create(Spell4GUI2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdvanceSpellGUIMenu>> ADVANCE_SPELL_GUI = REGISTRY.register("advance_spell_gui", () -> IMenuTypeExtension.create(AdvanceSpellGUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIsettingsMenu>> SPELL_4_GU_ISETTINGS = REGISTRY.register("spell_4_gu_isettings", () -> IMenuTypeExtension.create(Spell4GUIsettingsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIdetailsMenu>> SPELL_4_GU_IDETAILS = REGISTRY.register("spell_4_gu_idetails", () -> IMenuTypeExtension.create(Spell4GUIdetailsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIweaponBowMenu>> SPELL_4_GU_IWEAPON_BOW = REGISTRY.register("spell_4_gu_iweapon_bow", () -> IMenuTypeExtension.create(Spell4GUIweaponBowMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIweaponLanternMenu>> SPELL_4_GU_IWEAPON_LANTERN = REGISTRY.register("spell_4_gu_iweapon_lantern", () -> IMenuTypeExtension.create(Spell4GUIweaponLanternMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIweaponShieldMenu>> SPELL_4_GU_IWEAPON_SHIELD = REGISTRY.register("spell_4_gu_iweapon_shield", () -> IMenuTypeExtension.create(Spell4GUIweaponShieldMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIweaponAnchorMenu>> SPELL_4_GU_IWEAPON_ANCHOR = REGISTRY.register("spell_4_gu_iweapon_anchor", () -> IMenuTypeExtension.create(Spell4GUIweaponAnchorMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIweaponKnightSwordMenu>> SPELL_4_GU_IWEAPON_KNIGHT_SWORD = REGISTRY.register("spell_4_gu_iweapon_knight_sword",
			() -> IMenuTypeExtension.create(Spell4GUIweaponKnightSwordMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell4GUIsettings2Menu>> SPELL_4_GU_ISETTINGS_2 = REGISTRY.register("spell_4_gu_isettings_2", () -> IMenuTypeExtension.create(Spell4GUIsettings2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Spell1GUIMenu>> SPELL_1_GUI = REGISTRY.register("spell_1_gui", () -> IMenuTypeExtension.create(Spell1GUIMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUIDescriptionMenu>> GUI_DESCRIPTION = REGISTRY.register("gui_description", () -> IMenuTypeExtension.create(GUIDescriptionMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUIAdvanceSpellSelectMenu>> GUI_ADVANCE_SPELL_SELECT = REGISTRY.register("gui_advance_spell_select", () -> IMenuTypeExtension.create(GUIAdvanceSpellSelectMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUIIndexMenu>> GUI_INDEX = REGISTRY.register("gui_index", () -> IMenuTypeExtension.create(GUIIndexMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GUISpell4Menu>> GUI_SPELL_4 = REGISTRY.register("gui_spell_4", () -> IMenuTypeExtension.create(GUISpell4Menu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof TanscomplexmagicModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}