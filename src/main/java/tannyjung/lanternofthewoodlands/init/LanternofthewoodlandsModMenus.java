
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package tannyjung.lanternofthewoodlands.init;

import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponSwordMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponShieldMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponLanternMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponKnightSwordMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponBowMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIweaponAnchorMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIsettingsMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIsettings2Menu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIdetailsMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell4GUI2Menu;
import tannyjung.lanternofthewoodlands.world.inventory.Spell1GUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.PersonalWeaponGUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.PersonalWeaponGUI2Menu;
import tannyjung.lanternofthewoodlands.world.inventory.PersonalSkillGUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.PersonalSkillGUI2Menu;
import tannyjung.lanternofthewoodlands.world.inventory.MenuGUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.ManaRegenerationGUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.LawsOfMagicGUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.GUISpell4Menu;
import tannyjung.lanternofthewoodlands.world.inventory.GUIIndexMenu;
import tannyjung.lanternofthewoodlands.world.inventory.GUIDescriptionMenu;
import tannyjung.lanternofthewoodlands.world.inventory.GUIAdvanceSpellSelectMenu;
import tannyjung.lanternofthewoodlands.world.inventory.FromCreatorGUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.AllyListGUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.AllyListGUI2Menu;
import tannyjung.lanternofthewoodlands.world.inventory.AgreementGUIMenu;
import tannyjung.lanternofthewoodlands.world.inventory.AdvanceSpellGUIMenu;
import tannyjung.lanternofthewoodlands.LanternofthewoodlandsMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;

import javax.annotation.Nullable;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LanternofthewoodlandsModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, LanternofthewoodlandsMod.MODID);
	public static final RegistryObject<MenuType<Spell4GUIMenu>> SPELL_4_GUI = REGISTRY.register("spell_4_gui", () -> IForgeMenuType.create(Spell4GUIMenu::new));
	public static final RegistryObject<MenuType<AllyListGUIMenu>> ALLY_LIST_GUI = REGISTRY.register("ally_list_gui", () -> IForgeMenuType.create(AllyListGUIMenu::new));
	public static final RegistryObject<MenuType<FromCreatorGUIMenu>> FROM_CREATOR_GUI = REGISTRY.register("from_creator_gui", () -> IForgeMenuType.create(FromCreatorGUIMenu::new));
	public static final RegistryObject<MenuType<PersonalWeaponGUIMenu>> PERSONAL_WEAPON_GUI = REGISTRY.register("personal_weapon_gui", () -> IForgeMenuType.create(PersonalWeaponGUIMenu::new));
	public static final RegistryObject<MenuType<PersonalSkillGUIMenu>> PERSONAL_SKILL_GUI = REGISTRY.register("personal_skill_gui", () -> IForgeMenuType.create(PersonalSkillGUIMenu::new));
	public static final RegistryObject<MenuType<PersonalSkillGUI2Menu>> PERSONAL_SKILL_GUI_2 = REGISTRY.register("personal_skill_gui_2", () -> IForgeMenuType.create(PersonalSkillGUI2Menu::new));
	public static final RegistryObject<MenuType<PersonalWeaponGUI2Menu>> PERSONAL_WEAPON_GUI_2 = REGISTRY.register("personal_weapon_gui_2", () -> IForgeMenuType.create(PersonalWeaponGUI2Menu::new));
	public static final RegistryObject<MenuType<AllyListGUI2Menu>> ALLY_LIST_GUI_2 = REGISTRY.register("ally_list_gui_2", () -> IForgeMenuType.create(AllyListGUI2Menu::new));
	public static final RegistryObject<MenuType<ManaRegenerationGUIMenu>> MANA_REGENERATION_GUI = REGISTRY.register("mana_regeneration_gui", () -> IForgeMenuType.create(ManaRegenerationGUIMenu::new));
	public static final RegistryObject<MenuType<MenuGUIMenu>> MENU_GUI = REGISTRY.register("menu_gui", () -> IForgeMenuType.create(MenuGUIMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIweaponSwordMenu>> SPELL_4_GU_IWEAPON_SWORD = REGISTRY.register("spell_4_gu_iweapon_sword", () -> IForgeMenuType.create(Spell4GUIweaponSwordMenu::new));
	public static final RegistryObject<MenuType<AgreementGUIMenu>> AGREEMENT_GUI = REGISTRY.register("agreement_gui", () -> IForgeMenuType.create(AgreementGUIMenu::new));
	public static final RegistryObject<MenuType<LawsOfMagicGUIMenu>> LAWS_OF_MAGIC_GUI = REGISTRY.register("laws_of_magic_gui", () -> IForgeMenuType.create(LawsOfMagicGUIMenu::new));
	public static final RegistryObject<MenuType<Spell4GUI2Menu>> SPELL_4_GUI_2 = REGISTRY.register("spell_4_gui_2", () -> IForgeMenuType.create(Spell4GUI2Menu::new));
	public static final RegistryObject<MenuType<AdvanceSpellGUIMenu>> ADVANCE_SPELL_GUI = REGISTRY.register("advance_spell_gui", () -> IForgeMenuType.create(AdvanceSpellGUIMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIsettingsMenu>> SPELL_4_GU_ISETTINGS = REGISTRY.register("spell_4_gu_isettings", () -> IForgeMenuType.create(Spell4GUIsettingsMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIdetailsMenu>> SPELL_4_GU_IDETAILS = REGISTRY.register("spell_4_gu_idetails", () -> IForgeMenuType.create(Spell4GUIdetailsMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIweaponBowMenu>> SPELL_4_GU_IWEAPON_BOW = REGISTRY.register("spell_4_gu_iweapon_bow", () -> IForgeMenuType.create(Spell4GUIweaponBowMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIweaponLanternMenu>> SPELL_4_GU_IWEAPON_LANTERN = REGISTRY.register("spell_4_gu_iweapon_lantern", () -> IForgeMenuType.create(Spell4GUIweaponLanternMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIweaponShieldMenu>> SPELL_4_GU_IWEAPON_SHIELD = REGISTRY.register("spell_4_gu_iweapon_shield", () -> IForgeMenuType.create(Spell4GUIweaponShieldMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIweaponAnchorMenu>> SPELL_4_GU_IWEAPON_ANCHOR = REGISTRY.register("spell_4_gu_iweapon_anchor", () -> IForgeMenuType.create(Spell4GUIweaponAnchorMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIweaponKnightSwordMenu>> SPELL_4_GU_IWEAPON_KNIGHT_SWORD = REGISTRY.register("spell_4_gu_iweapon_knight_sword", () -> IForgeMenuType.create(Spell4GUIweaponKnightSwordMenu::new));
	public static final RegistryObject<MenuType<Spell4GUIsettings2Menu>> SPELL_4_GU_ISETTINGS_2 = REGISTRY.register("spell_4_gu_isettings_2", () -> IForgeMenuType.create(Spell4GUIsettings2Menu::new));
	public static final RegistryObject<MenuType<Spell1GUIMenu>> SPELL_1_GUI = REGISTRY.register("spell_1_gui", () -> IForgeMenuType.create(Spell1GUIMenu::new));
	public static final RegistryObject<MenuType<GUIDescriptionMenu>> GUI_DESCRIPTION = REGISTRY.register("gui_description", () -> IForgeMenuType.create(GUIDescriptionMenu::new));
	public static final RegistryObject<MenuType<GUIAdvanceSpellSelectMenu>> GUI_ADVANCE_SPELL_SELECT = REGISTRY.register("gui_advance_spell_select", () -> IForgeMenuType.create(GUIAdvanceSpellSelectMenu::new));
	public static final RegistryObject<MenuType<GUIIndexMenu>> GUI_INDEX = REGISTRY.register("gui_index", () -> IForgeMenuType.create(GUIIndexMenu::new));
	public static final RegistryObject<MenuType<GUISpell4Menu>> GUI_SPELL_4 = REGISTRY.register("gui_spell_4", () -> IForgeMenuType.create(GUISpell4Menu::new));

	public static void setText(String boxname, String value, @Nullable ServerPlayer player) {
		if (player != null) {
			LanternofthewoodlandsMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> player), new GuiSyncMessage(boxname, value));
		} else {
			LanternofthewoodlandsMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new GuiSyncMessage(boxname, value));
		}
	}

	public static class GuiSyncMessage {
		private final String textboxid;
		private final String data;

		public GuiSyncMessage(FriendlyByteBuf buffer) {
			this.textboxid = buffer.readComponent().getString();
			this.data = buffer.readComponent().getString();
		}

		public GuiSyncMessage(String textboxid, String data) {
			this.textboxid = textboxid;
			this.data = data;
		}

		public static void buffer(GuiSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeComponent(Component.literal(message.textboxid));
			buffer.writeComponent(Component.literal(message.data));
		}

		public static void handleData(GuiSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					LanternofthewoodlandsModScreens.handleTextBoxMessage(message);
				}
			});
			context.setPacketHandled(true);
		}

		String editbox() {
			return this.textboxid;
		}

		String value() {
			return this.data;
		}
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		LanternofthewoodlandsMod.addNetworkMessage(GuiSyncMessage.class, GuiSyncMessage::buffer, GuiSyncMessage::new, GuiSyncMessage::handleData);
	}
}
