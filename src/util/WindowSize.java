/*
 * Copyright (C) 2015 joulupunikki joulupunikki@gmail.communist.invalid.
 *
 *  Disclaimer of Warranties and Limitation of Liability.
 *
 *     The creators and distributors offer this software as-is and
 *     as-available, and make no representations or warranties of any
 *     kind concerning this software, whether express, implied, statutory,
 *     or other. This includes, without limitation, warranties of title,
 *     merchantability, fitness for a particular purpose, non-infringement,
 *     absence of latent or other defects, accuracy, or the presence or
 *     absence of errors, whether or not known or discoverable.
 *
 *     To the extent possible, in no event will the creators or distributors
 *     be liable on any legal theory (including, without limitation,
 *     negligence) or otherwise for any direct, special, indirect,
 *     incidental, consequential, punitive, exemplary, or other losses,
 *     costs, expenses, or damages arising out of the use of this software,
 *     even if the creators or distributors have been advised of the
 *     possibility of such losses, costs, expenses, or damages.
 *
 *     The disclaimer of warranties and limitation of liability provided
 *     above shall be interpreted in a manner that, to the extent possible,
 *     most closely approximates an absolute disclaimer and waiver of
 *     all liability.
 *
 */
package util;

import java.awt.Font;
import java.util.HashMap;
import java.util.function.BiFunction;
import util.C.GC;
import util.G.AAB;
import util.G.CD;
import util.G.CDW;
import util.G.CGW;
import util.G.CH;
import util.G.CIW;
import util.G.GF;
import util.G.OW;
import util.G.SS;

/**
 * GUI coordinates are stored here (x, y, width, height, etc of windows,
 * buttons, etc.)
 *
 * @author joulupunikki
 */
public class WindowSize {
    public int banner100_side = 100;
    public int treaty_flag_side = 27;
    public final boolean is_double;
    /**
     * Main window width;
     */
    public int main_window_width = 640;
    /**
     * Main window height;
     */
    public int main_window_height = 480;

    public int std_button_h = 16;
    public int space_map_x_pos = 124;
    public int space_map_y_pos = 29;
    public int space_map_width = 504;
    public int space_map_height = 435;
    public int space_map_square_width = 34;
    public int space_map_square_height = 34;
    public int starfld2_x_pos = 12;
    public int starfld2_y_pos = 9;
    public int planet_map_x_offset = 124;
    public int planet_map_y_offset = 32;
    public int planet_map_width = 504;
    public int planet_map_height = 400;
    public int planet_image_side = 32;
    public int unit_icon_size = 34;
    public int font_unit_icon_offset = 1;
    public int font_unit_icon_size = 9;
    public Font font_unit_icon;
    public int font_structure_name_size = 8;
    public Font font_structure_name_fg;
    public Font font_structure_name_bg;
    public int font_structure_name_gap = 1;
    public int stack_display_x_offset = 9;
    public int stack_display_y_offset = 181;
    public int stack_display_x2 = stack_display_x_offset + 3 * unit_icon_size;
    public int stack_display_y2 = stack_display_y_offset + 6 * unit_icon_size;
    public int stack_display_x3 = 9;
    public int stack_display_y3 = stack_display_y_offset + 6 * unit_icon_size;
    public int stack_display_x4 = stack_display_x_offset + 2 * unit_icon_size;
    public int stack_display_y4 = stack_display_y_offset + 7 * unit_icon_size;
    public int health_bar_width = 1;
    public int planet_map_hex_center_x_gap = 38;
    public int planet_map_hex_center_y_gap = 40;
    public int blip_side = 7;
    public int path_circle = 10;
    public int font_path_numbers_size = 20;
    public Font font_path_numbers;
    public double smxo = 1.9;
    public double smyo = 1.0;
    public int unit_panel_x_offset = 10;
    public int unit_panel_y_offset = 220;
    public int stack_window_exit_button_x = 570;
    public int stack_window_exit_button_y = 440;
    public int stack_window_exit_button_w = 40;
    public int stack_window_exit_button_h = 15;
    public int launch_button_x_offset = 95;
    public int launch_button_y_offset = 50;
    public int launch_button_width = 23;
    public int launch_button_height = 41;
    public int info_text_field_x = stack_display_x_offset;
    public int info_text_field_y = 100;
    public int info_text_field_y_space = 128;
    public int info_text_field_w = stack_display_x2 - stack_display_x_offset;
    public int info_text_field_h = 10;
    public Font font_default;
    public int font_default_size = 10;
    public int end_turn_button_w = 54;
    public int end_turn_button_h = 50;
    public int end_turn_button_x = 7;
    public int end_turn_button_y = 425;
    public int unit_order_buttons_x = 61;
    public int unit_order_buttons_y = 425;
    public int unit_order_buttons_w = 25;
    public int unit_order_buttons_h = 25;
    public int carry_symbol_x = 4;
    public int carry_symbol_y = 26;
    public int carry_symbol_w = 12;
    public int carry_symbol_h = 4;
    public Font font_abbrev;
    public int human_control_selection_x = 100;
    public int human_control_selection_y = 100;
    public int human_control_selection_w = 100;
    public int human_control_selection_h = 25;
    public int combat_window_stack_display_gap = 5;
    public int combat_window_stack_display_w = 5 * unit_icon_size + 6 * combat_window_stack_display_gap;
    public int combat_window_stack_display_h = 4 * unit_icon_size + 5 * combat_window_stack_display_gap;
    public int combat_window_stack_display_x = 15;
    public int combat_window_stack_display_x2 = main_window_width - combat_window_stack_display_w - combat_window_stack_display_x;
    public int combat_window_stack_display_y = 260;
    public int combat_window_fight_button_x = 258;
    public int combat_window_fight_button_y = 453;
    public int combat_window_fight_button_w = 124;
    public int combat_window_fight_button_h = 15;
    public int combat_window_bombard_again_button_y = 428;
    public int cw_att_n_x = 127;
    public int cw_def_n_x = 513;
    public int cw_att_n_y1 = 18;

    public int skull_offset = 3;
    public int skull_side = 40;
    public int unit_info_attack_type_x = 310;
    public int unit_info_attack_type_y = 118;
    public int unit_info_attack_stat_x = 370;
    public int unit_info_attack_stat_y = unit_info_attack_type_y;
    public int unit_info_attack_type_w = 60;
    public int unit_info_attack_type_h = 11;
    public int unit_info_attack_stat_w = 60;
    public int unit_info_attack_stat_h = unit_info_attack_type_h;
    public int unit_info_left_stat_x = 135;
    public int unit_info_left_stat_y = unit_info_attack_type_y;
    public int unit_info_left_stat_w = 30;
    public int unit_info_left_stat_h = unit_info_attack_type_h;
    public int unit_info_left_stat_x2 = 180;
    public int ui_disband_x = 554;
    public int ui_disband_y = 165;
    public int ui_disband_w = 62;
    public int ui_unload_x = 525;
    public int ui_unload_y = 408;
    public int ui_unload_w = 102;
    public int ui_button_gap = 25;
    public int ui_unit_block_w = 108;

    public int galactic_map_x_pos = 10;
    public int galactic_map_y_pos = 23;
    public int galactic_map_width = 100;
    public int galactic_map_height = 96;
    public int globe_map_x_pos = 3;
    public int globe_map_y_pos = 28;
    public int globe_map_width = 88;
    public int globe_map_height = 63;

    public int space_button_x_offset = 95;
    public int space_button_y_offset = 25;
    public int space_button_width = 23;
    public int space_button_height = 23;

    public int planet_list_cell_w = 100;
    public int planet_list_cell_h = 10;
    public int planet_list_x_offset = 0;
    public int planet_list_y_offset = 209;
    public int planet_list_width = planet_map_width / 2;
    public int planet_list_height = planet_map_height - 209;
    public int city_table_x_offset = planet_map_width / 2;
    public int city_table_row_height = 10;
    public int build_window_width = planet_map_width + 18;
    public int build_window_height = planet_map_height + 40;
    public int build_table_x_offset = 60;
    public int build_table_y_offset = 5;
    public int build_table_width = planet_map_width / 2;
    public int build_table_height = 105;
    public int build_table_cell_1_width = build_table_width / 5;
    public int build_table_cell_0_width = build_table_width - build_table_cell_1_width;
    public int queue_table_x_offset = 317;
    public int queue_table_y_offset = 10;
    public int queue_table_width = 175;
    public int queue_table_height = 150;
    public int queue_table_cell_1_width = queue_table_width / 5;
    public int queue_table_cell_0_width = queue_table_width - queue_table_cell_1_width;
    public int build_button_x_offset = 60;
    public int build_button_y_offset = 161;
    public int build_button_w = 50;
    public int build_button_h = 15;
    public int city_build_button_w = 50;
    public int city_build_button_h = 15;
    public int city_build_button_x_offset = 8;
    public int city_build_button_y_offset = 93;

    public int city_exit_button_w = 50;
    public int city_exit_button_h = 15;
    public int city_exit_button_x_offset = 438;
    public int city_exit_button_y_offset = 93;

    public int city_window_x = 120;
    public int city_window_y = 20;
    public int city_window_w = 510;
    public int city_window_h = 120;
    public int city_panel_city_area_x = 8;

    public int city_name_display_x_offset = 10;
    public int city_name_display_y_offset = 10;
    public int city_name_display_w = 50;
    public int city_name_display_h = 15;

    public int build_exit_button_w = 50;
    public int build_exit_button_h = 15;
    public int build_exit_button_x_offset = planet_map_width - build_exit_button_w - 10;
    public int build_exit_button_y_offset = planet_map_height / 2 - build_exit_button_h - 10;

    public int tech_window_w = 640;
    public int tech_window_h = 350;
    public int tech_window_x_offset = 0;
    public int tech_window_y_offset = 90;

    public int tech_table_w = 450;
    public int tech_table_h = 120;
    public int tech_table_x_offset = 150;
    public int tech_table_y_offset = 25;

    public int tech_column_0_w = tech_table_w / 2;
    public int tech_column_1_w = tech_table_w / 6;
    public int tech_column_2_w = tech_table_w / 6;
    public int tech_column_3_w = tech_table_w / 6;
//    public int tech_column_4_w = tech_table_w / 6;

    public int tech_db_button_w = 50;
    public int tech_db_button_h = 15;
    public int tech_db_button_x_offset = tech_window_w / 2 - tech_db_button_w - 10;
    public int tech_db_button_y_offset = tech_window_h - tech_db_button_h - 10;

    public int tech_exit_button_w = 50;
    public int tech_exit_button_h = 15;
    public int tech_exit_button_x_offset = tech_window_w * 3 / 4 - tech_db_button_w - 10;
    public int tech_exit_button_y_offset = tech_window_h - tech_db_button_h - 10;

    public int tech_archive_button_w = 50;
    public int tech_archive_button_h = 15;
    public int tech_archive_button_x_offset = tech_window_w / 4 - tech_db_button_w - 10;
    public int tech_archive_button_y_offset = tech_window_h - tech_db_button_h - 10;

    public int tech_info_w = 450;
    public int tech_info_h = 120;
    public int tech_info_x_offset = 150;
    public int tech_info_y_offset = tech_window_h - tech_info_h - 10 - tech_db_button_h - 10;

    public int tech_labs_cost_x_offset = 151;
    public int tech_labs_cost_y_offset = 147;
    public int tech_labs_cost_w = 446;
    public int tech_labs_cost_h = 15;

    public int manowitz_window_w = 640;
    public int manowitz_window_h = 480;
    public int manowitz_window_x_offset = 0;
    public int manowitz_window_y_offset = 0;

    public int left_page_w = 195;
    public int left_page_h = 315;
    public int left_page_x_offset = 75;
    public int left_page_y_offset = 57;

    public int right_page_x_offset = manowitz_window_w - left_page_w - left_page_x_offset;

    public int manowitz_contents_x_offset = 16;
    public int manowitz_contents_y_offset = 455;
    public int manowitz_contents_w = 73;
    public int manowitz_contents_h = 25;

    public int manowitz_prev_x_offset = 136;
    public int manowitz_prev_y_offset = 439;
    public int manowitz_prev_w = 81;
    public int manowitz_prev_h = 41;

    public int manowitz_next_x_offset = 400;
    public int manowitz_next_y_offset = 439;
    public int manowitz_next_w = 89;
    public int manowitz_next_h = 41;

    public int manowitz_close_x_offset = 536;
    public int manowitz_close_y_offset = 455;
    public int manowitz_close_w = 81;
    public int manowitz_close_h = 25;

    //planet window resource display textfields
    public int pw_res_display_w = 31;
    public int pw_res_display_h = 10;
    public int pw_res_display_x_offset = 129;
    public int pw_res_display_y_offset = 475 - pw_res_display_h;
    public int pw_res_display_x_gap = 38;

    //build panel resource display textfields
    public int bp_res_display_w = 31;
    public int bp_res_display_h = 10;
    public int bp_res_display_x_offset = 11;
    public int bp_res_display_y_offset = 199 - bp_res_display_h;

    //resource window
    public int rw_x_offset = 124;
    public int rw_y_offset = 32;
    public int rw_width = 504;
    public int rw_height = 300;

    //resource icon coordinates on planet window
    public int ri_x = 128;
    public int ri_y = 442;
    public int ri_w = C.CARGO_WIDTH;
    public int ri_h = C.CARGO_HEIGHT;
    public int ri_x_gap = 38;

    //resource window exit button
    public int rw_exit_width = 50;
    public int rw_exit_height = 15;
    public int rw_exit_x_offset = rw_width - rw_exit_width - 10;
    public int rw_exit_y_offset = rw_height - rw_exit_height - 10;

    //resource window prod/cons textfields
    public int rw_pct_x_offset = 5;
    public int rw_pct_width = rw_exit_x_offset - rw_pct_x_offset - 5;
    public int rw_pct_height = 15;
    public int rw_pct_y_offset = rw_height - rw_pct_height - rw_exit_height - 5;

    //resource window resource name
    public int rw_rn_x = C.CARGO_WIDTH + 5;
    public int rw_rn_y = 5;
    public int rw_rn_w = rw_width / 2;
    public int rw_rn_h = 15;

//    //planet window resource display text postions
//    public int pw_rdt_x = 129;
//    public int pw_rdt_y = 475;
//    public int pw_rdt_w = 31;
//    public int pw_rdt_x_gap = 38;
    //build city window city icons
    public int bcw_ci_w = C.STRUCT_BIN_WIDTH;
    public int bcw_ci_h = C.STRUCT_BIN_HEIGHT;
    public int bcw_ci_x = 5;
    public int bcw_ci_y = 5;
    public int bcw_ci_gap = bcw_ci_h + bcw_ci_y;

    //build city window upper labels
    public int bcw_ul_w = 30;
    public int bcw_ul_h = 10;
    public int bcw_ul_x = bcw_ci_x * 2 + bcw_ci_w;
    public int bcw_ul_y = 5;

    public Font font_bcw_2;
    public int font_bcw_2_size = 9;

    //build city window lower labels
    public int bcw_ll_w = 30;
    public int bcw_ll_h = 8;
    public int bcw_ll_x = bcw_ci_x * 2 + bcw_ci_w;
    public int bcw_ll_y = 5 + bcw_ul_h;

    //full window (640x480) exit button, lower right corner
    public int fw_eb_w = 50;
    public int fw_eb_h = 15;
    public int fw_eb_x = main_window_width - fw_eb_w - 5;
    public int fw_eb_y = main_window_height - fw_eb_h - 5;

    //standard button width & height
    public int sb_w = 50;
    public int sb_h = 15;

    //build city window build button
    public int bcw_bb_x = fw_eb_x - 5 - sb_w;

    //main menu pbem button
    public int mm_pbem_w = 100;
    public int mm_pbem_h = 30;
    public int mm_pbem_x = main_window_width - mm_pbem_w - 10;
    public int mm_pbem_y = main_window_height - 3 * mm_pbem_h;

    //main menu start new button
    public int mm_sn_w = main_window_width / 3;
    public int mm_sn_y = main_window_height * 2 / 5;
    public int mm_sn_x = mm_sn_w;

    public Font font_large;
    public int font_large_size = 11;

    // messages window message table
    public int mwmt_w = 300;
    public int mwmt_h = 400;
    public int mwmt_x = 50;
    public int mwmt_y = 50;

    // combat window gal minimap
    public int cw_gm_w = galactic_map_width;
    public int cw_gm_h = galactic_map_height;
    public int cw_gm_x = main_window_width / 2 - cw_gm_w / 2;
    public int cw_gm_y = main_window_height * 6 / 19;

    // combat window global minimap
    public int cw_glm_w = globe_map_width;
    public int cw_glm_h = globe_map_height;
    public int cw_glm_x = main_window_width / 2 - cw_glm_w / 2;
    public int cw_glm_y = main_window_height * 11 / 19;

    // combat window planet name
    public int cw_pn_w = cw_glm_w * 7 / 3;
    public int cw_pn_h = 15;
    public int cw_pn_x = main_window_width / 2 - cw_pn_w / 2;
    public int cw_pn_y = cw_glm_y - 5 - cw_pn_h;

    // messages window view replays
    public int mw_vr_w = 125;
    public int mw_vr_x = fw_eb_x - mw_vr_w + fw_eb_w;

    // cargo panel win
    public int cpw_w = 198;
    public int cpw_h = 329 - 150;
    public int cpw_x = (main_window_width - cpw_w) / 2;
    public int cpw_y = (main_window_height - cpw_h) / 2;

    // cargo panel title
    public int cp_t_x = 28;
    public int cp_t_y = 18;
    public int cp_t_w = (cpw_w - cp_t_x) / 2;
    public int cp_t_h = 15;

    // cargo panel buttons
    public int cp_b_y_gap = 30;
    public int cp_b_w = 351 - 248;

    // cargo panel slider
    public int cp_s_x = 158;
    public int cp_s_w = 15;
    public int cp_s_h = 100;

    // stack window left stats panel
    public int sw_lsp_x = 133;
    public int sw_lsp_y = 117;
    public int sw_lsp_w = 74;
    public int sw_lsp_h = 45;

    // stack window right stats panel
    public int sw_rsp_x = 214;

    // stack window attack panel
    public int sw_ap_x = 304;
    public int sw_ap_w = 130;
    public int sw_ap_h = 45;
    // stack window unit image/animation
    public int sw_flc_x = 442;
    public int sw_flc_y = 11;
    // stack window top unit details
    public int sw_tp_x = 222;
    public int sw_tp_x2 = 233;
    public int sw_tp_y = 16;
    public int sw_tp_y2 = 31;
    public int sw_tp_h = 12;
    // stack window city area upper left coordinates
    public int sw_city_x = 127;
    public int sw_city_y = 384;
    // city area coordinates, for stack window and city panel
    public int city_img_x = 0;
    public int city_img_y = 0;
    public int city_name_x = 58;
    public int city_name_y = 9;
    public int city_harvest_x = 57;
    public int city_harvest_y = 20;
    public int city_harvest_y2 = 31;
    public int city_loyalty_x = 57;
    public int city_loyalty_y = 41;

    // build panel left stats panel
    public int bp_lsp_x = 9;

    // build panel right stats panel
    public int bp_rsp_x = 90;

    // build panel attack stats panel
    public int bp_asp_x = 180;
    public int bp_asp_w = 130;
    public int bp_asp_h = 45;

    // unit stats statistics
    public int us_s_name_x1 = 0;
    public int us_s_name_x2 = 36;
    public int us_s_name_y1 = 0;
    public int us_s_name_y2 = 10;
    public int us_s_name_w = us_s_name_x2 - us_s_name_x1 + 1;
    public int us_s_name_h = us_s_name_y2 - us_s_name_y1 + 1;
    public int us_s_value_x1 = 37;
    public int us_s_value_x2 = 73;

    // unit stats attack
    public int us_a_name_x1 = 0;
    public int us_a_name_x2 = 64;
    public int us_a_name_y1 = 0;
    public int us_a_name_y2 = 10;
    public int us_a_name_w = us_a_name_x2 - us_a_name_x1 + 1;
    public int us_a_name_h = us_a_name_y2 - us_a_name_y1 + 1;
    public int us_a_value_x1 = 65;
    public int us_a_value_x2 = 129;

    // byzantium II screen
    public int bz2_ministry_y1 = 181;
    public int bz2_ministry_y2 = 303;
    public int bz2_stigmata_x1 = 66;
    public int bz2_stigmata_x2 = 185;
    public int bz2_eye_x1 = 261;
    public int bz2_eye_x2 = 380;
    public int bz2_fleet_x1 = 456;
    public int bz2_fleet_x2 = 575;
    public int bz2_regent_x1 = bz2_eye_x1;
    public int bz2_regent_x2 = bz2_eye_x2;
    public int bz2_regent_y1 = 32;
    public int bz2_regent_y2 = 154;

    public int bz2_house_names_y1 = 426;
    public int bz2_house_names_y2 = 442;
    public int bz2_house_names_x11 = 31;
    public int bz2_house_names_x12 = 151;
    public int bz2_house_names_x13 = 271;
    public int bz2_house_names_x14 = 391;
    public int bz2_house_names_x15 = 511;
    public int bz2_house_names_w = 99;
    public int bz2_house_banner_y1 = 324;
    public int bz2_house_banner_y2 = 423;
    public int bz2_button1_x = 25;
    public int bz2_button1_y = 455;
    public int bz2_button1_w = 235;
    public int bz2_button1_h = 15;

    public int menubar_h = 18;

    public int d = 1;
    public HashMap<Enum, Integer> agora;
    public HashMap<Enum, Integer> house;
    public HashMap<Enum, Integer> diplomacy_selector;
    public HashMap<Enum, Integer> diplomacy_window;
    public HashMap<Enum, Integer> galaxy_window;
    public HashMap<Enum, Integer> options_window;
    public HashMap<Enum, Integer> strategy_selector;
    public HashMap<Enum, Integer> group_finder;
    public HashMap<Enum, Integer> agora_auto_buy;
    public HashMap<Enum, Integer> city_info;




    private final Doubler mul2;

    public WindowSize(boolean is_double) {
        this.mul2 = new Doubler();
        this.is_double = is_double;
        iAgora(is_double);
        iHouse(is_double);
        iDiplomacy(is_double);
        iDiplomacyWindow(is_double);
        iGalaxyWindow(is_double);
        iOptionsWindow(is_double);
        iStrategy(is_double);
        iGroupFinder(is_double);
        iAgoraAutobuy(is_double);
        iCityInfo(is_double);
        if (is_double) {
            banner100_side *= 2;
            treaty_flag_side *= 2;
            d = 2;
            main_window_width *= 2;
            main_window_height *= 2;
            std_button_h *= 2;
            space_map_x_pos *= 2;
            space_map_y_pos *= 2;
            space_map_width *= 2;
            space_map_height *= 2;
            space_map_square_width *= 2;
            space_map_square_height *= 2;

            planet_map_x_offset *= 2;
            planet_map_y_offset *= 2;
            planet_map_width *= 2;
            planet_map_height *= 2;

            starfld2_x_pos *= 2;
            starfld2_y_pos *= 2;

            planet_image_side *= 2;

            unit_icon_size *= 2;
            font_unit_icon_size *= 2;
            font_unit_icon_offset *= 2;
            font_structure_name_size *= 2;

            stack_display_x_offset *= 2;
            stack_display_y_offset *= 2;

            health_bar_width *= 2;

            planet_map_hex_center_x_gap *= 2;
            planet_map_hex_center_y_gap *= 2;

            stack_display_x2 *= 2;
            stack_display_y2 *= 2;

            stack_display_x3 *= 2;
            stack_display_y3 *= 2;
            stack_display_x4 *= 2;
            stack_display_y4 *= 2;

            blip_side *= 2;

            font_structure_name_gap *= 2;

            path_circle *= 2;
            font_path_numbers_size *= 2;

            smxo *= 2;
            smyo *= 2;
            unit_panel_x_offset *= 2;
            unit_panel_y_offset *= 2;

            stack_window_exit_button_x *= 2;
            stack_window_exit_button_y *= 2;
            stack_window_exit_button_w *= 2;
            stack_window_exit_button_h *= 2;
            launch_button_x_offset *= 2;
            launch_button_y_offset *= 2;
            launch_button_width *= 2;
            launch_button_height *= 2;

            info_text_field_x *= 2;
            info_text_field_y *= 2;
            info_text_field_w *= 2;
            info_text_field_h *= 2;

            font_default_size *= 2;
            info_text_field_y_space *= 2;

            end_turn_button_w *= 2;
            end_turn_button_h *= 2;
            end_turn_button_x *= 2;
            end_turn_button_y *= 2;
            unit_order_buttons_x *= 2;
            unit_order_buttons_y *= 2;
            unit_order_buttons_w *= 2;
            unit_order_buttons_h *= 2;

            carry_symbol_x *= 2;
            carry_symbol_y *= 2;
            carry_symbol_w *= 2;
            carry_symbol_h *= 2;

            human_control_selection_x *= 2;
            human_control_selection_y *= 2;
            human_control_selection_w *= 2;
            human_control_selection_h *= 2;

            combat_window_stack_display_x *= 2;
            combat_window_stack_display_x2 *= 2;
            combat_window_stack_display_y *= 2;
            combat_window_stack_display_w *= 2;
            combat_window_stack_display_h *= 2;

            combat_window_fight_button_x *= 2;
            combat_window_fight_button_y *= 2;
            combat_window_fight_button_w *= 2;
            combat_window_fight_button_h *= 2;
            combat_window_bombard_again_button_y *= 2;
            cw_att_n_x *= 2;
            cw_def_n_x *= 2;
            cw_att_n_y1 *= 2;
            skull_offset *= 2;
            skull_side *= 2;

            unit_info_attack_type_x *= 2;
            unit_info_attack_type_y *= 2;
            unit_info_attack_stat_x *= 2;
            unit_info_attack_stat_y *= 2;
            unit_info_attack_type_w *= 2;
            unit_info_attack_type_h *= 2;
            unit_info_attack_stat_w *= 2;
            unit_info_attack_stat_h *= 2;
            unit_info_left_stat_x *= 2;
            unit_info_left_stat_y *= 2;
            unit_info_left_stat_w *= 2;
            unit_info_left_stat_h *= 2;
            unit_info_left_stat_x2 *= 2;
            ui_disband_x *= 2;
            ui_disband_y *= 2;
            ui_disband_w *= 2;
            ui_unload_x *= 2;
            ui_unload_y *= 2;
            ui_unload_w *= 2;
            ui_button_gap *= 2;
            ui_unit_block_w *= 2;
            galactic_map_x_pos *= 2;
            galactic_map_y_pos *= 2;
            galactic_map_width *= 2;
            galactic_map_height *= 2;

            globe_map_x_pos *= 2;
            globe_map_y_pos *= 2;
            globe_map_width *= 2;
            globe_map_height *= 2;
            planet_list_cell_w *= 2;
            planet_list_cell_h *= 2;
            planet_list_x_offset *= 2;
            planet_list_y_offset *= 2;
            planet_list_width *= 2;
            planet_list_height *= 2;
            city_table_x_offset *= 2;

            build_window_width = planet_map_width + 18;
            build_window_height = planet_map_height + 40;
            build_table_x_offset *= 2;
            build_table_y_offset *= 2;
            build_table_width *= 2;
            build_table_height *= 2;
            city_table_row_height *= 2;
            build_table_cell_0_width *= 2;
            build_table_cell_1_width *= 2;
            queue_table_x_offset *= 2;
            queue_table_y_offset *= 2;
            queue_table_width *= 2;
            queue_table_height *= 2;
            queue_table_cell_1_width *= 2;
            queue_table_cell_0_width *= 2;
            build_button_x_offset *= 2;
            build_button_y_offset *= 2;
            build_button_w *= 2;
            build_button_h *= 2;
            city_build_button_x_offset *= 2;
            city_build_button_y_offset *= 2;
            city_build_button_w *= 2;
            city_build_button_h *= 2;

            city_exit_button_w *= 2;
            city_exit_button_h *= 2;
            city_exit_button_x_offset *= 2;
            city_exit_button_y_offset *= 2;

            city_window_x *= 2;
            city_window_y *= 2;
            city_window_w *= 2;
            city_window_h *= 2;
            city_panel_city_area_x *= 2;
            city_panel_city_area_x *= 2;
            city_name_display_x_offset *= 2;
            city_name_display_y_offset *= 2;
            city_name_display_w *= 2;
            city_name_display_h *= 2;

            build_exit_button_w *= 2;
            build_exit_button_h *= 2;
            build_exit_button_x_offset *= 2;
            build_exit_button_y_offset *= 2;

            space_button_x_offset *= 2;
            space_button_y_offset *= 2;
            space_button_width *= 2;
            space_button_height *= 2;

            tech_window_w *= 2;
            tech_window_h *= 2;
            tech_window_x_offset *= 2;
            tech_window_y_offset *= 2;

            tech_table_w *= 2;
            tech_table_h *= 2;
            tech_table_x_offset *= 2;
            tech_table_y_offset *= 2;

            tech_column_0_w *= 2;
            tech_column_1_w *= 2;
            tech_column_2_w *= 2;
            tech_column_3_w *= 2;
//            tech_column_4_w *= 2;
            tech_db_button_w *= 2;
            tech_db_button_h *= 2;
            tech_db_button_x_offset *= 2;
            tech_db_button_y_offset *= 2;

            tech_exit_button_w *= 2;
            tech_exit_button_h *= 2;
            tech_exit_button_x_offset *= 2;
            tech_exit_button_y_offset *= 2;

            tech_info_w *= 2;
            tech_info_h *= 2;
            tech_info_x_offset *= 2;
            tech_info_y_offset *= 2;

            manowitz_window_w *= 2;
            manowitz_window_h *= 2;
            manowitz_window_x_offset *= 2;
            manowitz_window_y_offset *= 2;

            tech_archive_button_w *= 2;
            tech_archive_button_h *= 2;
            tech_archive_button_x_offset *= 2;
            tech_archive_button_y_offset *= 2;

            left_page_w *= 2;
            left_page_h *= 2;
            left_page_x_offset *= 2;
            left_page_y_offset *= 2;

            right_page_x_offset *= 2;

            manowitz_contents_x_offset *= 2;
            manowitz_contents_y_offset *= 2;
            manowitz_contents_w *= 2;
            manowitz_contents_h *= 2;

            manowitz_prev_x_offset *= 2;
            manowitz_prev_y_offset *= 2;
            manowitz_prev_w *= 2;
            manowitz_prev_h *= 2;

            manowitz_next_x_offset *= 2;
            manowitz_next_y_offset *= 2;
            manowitz_next_w *= 2;
            manowitz_next_h *= 2;

            manowitz_close_x_offset *= 2;
            manowitz_close_y_offset *= 2;
            manowitz_close_w *= 2;
            manowitz_close_h *= 2;

            tech_labs_cost_x_offset *= 2;
            tech_labs_cost_y_offset *= 2;
            tech_labs_cost_w *= 2;
            tech_labs_cost_h *= 2;

            pw_res_display_x_offset *= 2;
            pw_res_display_y_offset *= 2;
            pw_res_display_w *= 2;
            pw_res_display_h *= 2;
            pw_res_display_x_gap *= 2;

            bp_res_display_w *= 2;
            bp_res_display_h *= 2;
            bp_res_display_x_offset *= 2;
            bp_res_display_y_offset *= 2;

            rw_x_offset *= 2;
            rw_y_offset *= 2;
            rw_width *= 2;
            rw_height *= 2;

            ri_x *= 2;
            ri_y *= 2;
            ri_w *= 2;
            ri_h *= 2;
            ri_x_gap *= 2;

            rw_exit_x_offset *= 2;
            rw_exit_y_offset *= 2;
            rw_exit_width *= 2;
            rw_exit_height *= 2;

            rw_pct_x_offset *= 2;
            rw_pct_y_offset *= 2;
            rw_pct_width *= 2;
            rw_pct_height *= 2;

            rw_rn_x *= 2;
            rw_rn_y *= 2;
            rw_rn_w *= 2;
            rw_rn_h *= 2;

//            pw_rdt_x *= 2;
//            pw_rdt_y *= 2;
//            pw_rdt_w *= 2;
//            pw_rdt_x_gap *= 2;
            bcw_ci_w *= 2;
            bcw_ci_h *= 2;
            bcw_ci_x *= 2;
            bcw_ci_y *= 2;
            bcw_ci_gap *= 2;

            bcw_ul_w *= 2;
            bcw_ul_h *= 2;
            bcw_ul_x *= 2;
            bcw_ul_y *= 2;

            font_bcw_2_size *= 2;

            bcw_ll_w *= 2;
            bcw_ll_h *= 2;
            bcw_ll_x *= 2;
            bcw_ll_y *= 2;

            fw_eb_w *= 2;
            fw_eb_h *= 2;
            fw_eb_x *= 2;
            fw_eb_y *= 2;

            sb_w *= 2;
            sb_h *= 2;

            bcw_bb_x *= 2;

            mm_pbem_w *= 2;
            mm_pbem_h *= 2;
            mm_pbem_x *= 2;
            mm_pbem_y *= 2;

            mm_sn_w *= 2;
            mm_sn_y *= 2;
            mm_sn_x *= 2;

            font_large_size *= 2;

            mwmt_w *= 2;
            mwmt_h *= 2;
            mwmt_x *= 2;
            mwmt_y *= 2;

            cw_gm_w *= 2;
            cw_gm_h *= 2;
            cw_gm_x *= 2;
            cw_gm_y *= 2;

            cw_glm_w *= 2;
            cw_glm_h *= 2;
            cw_glm_x *= 2;
            cw_glm_y *= 2;

            cw_pn_w *= 2;
            cw_pn_h *= 2;
            cw_pn_x *= 2;
            cw_pn_y *= 2;

            mw_vr_w *= 2;
            mw_vr_x *= 2;

            cpw_w *= 2;
            cpw_h *= 2;
            cpw_x *= 2;
            cpw_y *= 2;

            cp_b_y_gap *= 2;
            cp_b_w *= 2;

            cp_t_x *= 2;
            cp_t_y *= 2;
            cp_t_w *= 2;
            cp_t_h *= 2;

            cp_s_x *= 2;
            cp_s_w *= 2;
            cp_s_h *= 2;

            sw_lsp_x *= 2;
            sw_lsp_y *= 2;
            sw_lsp_w *= 2;
            sw_lsp_h *= 2;

            sw_rsp_x *= 2;

            sw_ap_x *= 2;
            sw_ap_w *= 2;
            sw_ap_h *= 2;
            sw_flc_x *= 2;
            sw_flc_y *= 2;
            sw_tp_x *= 2;
            sw_tp_x2 *= 2;
            sw_tp_y *= 2;
            sw_tp_y2 *= 2;
            sw_tp_h *= 2;

            sw_city_x *= 2;
            sw_city_y *= 2;

            city_img_x *= 2;
            city_img_y *= 2;
            city_name_x *= 2;
            city_name_y *= 2;
            city_harvest_x *= 2;
            city_harvest_y *= 2;
            city_harvest_y2 *= 2;
            city_loyalty_x *= 2;
            city_loyalty_y *= 2;

            bp_lsp_x *= 2;

            bp_rsp_x *= 2;

            bp_asp_x *= 2;
            bp_asp_w *= 2;
            bp_asp_h *= 2;

            us_s_name_x1 *= 2;
            us_s_name_x2 *= 2;
            us_s_name_y1 *= 2;
            us_s_name_y2 *= 2;
            us_s_name_w *= 2;
            us_s_name_h *= 2;
            us_s_value_x1 *= 2;
            us_s_value_x2 *= 2;

            us_a_name_x1 *= 2;
            us_a_name_x2 *= 2;
            us_a_name_y1 *= 2;
            us_a_name_y2 *= 2;
            us_a_name_w *= 2;
            us_a_name_h *= 2;
            us_a_value_x1 *= 2;
            us_a_value_x2 *= 2;

            bz2_ministry_y1 *= 2;
            bz2_ministry_y2 *= 2;
            bz2_stigmata_x1 *= 2;
            bz2_stigmata_x2 *= 2;
            bz2_eye_x1 *= 2;
            bz2_eye_x2 *= 2;
            bz2_fleet_x1 *= 2;
            bz2_fleet_x2 *= 2;
            bz2_regent_x1 *= 2;
            bz2_regent_x2 *= 2;
            bz2_regent_y1 *= 2;
            bz2_regent_y2 *= 2;

            bz2_house_names_y1 *= 2;
            bz2_house_names_y2 *= 2;
            bz2_house_names_x11 *= 2;
            bz2_house_names_x12 *= 2;
            bz2_house_names_x13 *= 2;
            bz2_house_names_x14 *= 2;
            bz2_house_names_x15 *= 2;
            bz2_house_names_w *= 2;

            bz2_house_banner_y1 *= 2;
            bz2_house_banner_y2 *= 2;

            bz2_button1_x *= 2;
            bz2_button1_y *= 2;
            bz2_button1_w *= 2;
            bz2_button1_h *= 2;
            menubar_h *= 2;
        }
        font_unit_icon = new Font("Arial", Font.PLAIN, font_unit_icon_size);

        font_structure_name_fg = new Font("Arial", Font.BOLD, font_structure_name_size);

        font_path_numbers = new Font("Arial", Font.BOLD, font_path_numbers_size);

        font_default = new Font("Arial", Font.BOLD, font_default_size);

        font_abbrev = new Font("Arial", Font.PLAIN, font_default_size);

        font_bcw_2 = new Font("Arial", Font.PLAIN, font_bcw_2_size);

        font_large = new Font("Arial", Font.BOLD, font_large_size);
    }

    private void iAgora(boolean is_double) {
        agora = new HashMap<>();
        agora.put(GC.FOOD_X, 66);
        agora.put(GC.FOOD_Y, 38);
        agora.put(GC.LINE_H, 29);
        agora.put(GC.BOX_H, 19);
        agora.put(GC.HEADER_Y, 15);
        agora.put(GC.SELL_H_X, 199);
        agora.put(GC.AVAIL_H_X, 239);
        agora.put(GC.BUY_H_X, 301);
        agora.put(GC.AMT_H_X, 497);
        agora.put(GC.COST_H_X, 568);
        agora.put(GC.SELL_V_X, 223);
        agora.put(GC.AVAIL_V_X, 273);
        agora.put(GC.BUY_V_X, 323);
        agora.put(GC.AMT_V_X, 474);
        agora.put(GC.AMT_V_Y, 25);
        agora.put(GC.AMT_V_W, 52);
        agora.put(GC.COST_V_X, 549);
        agora.put(GC.SLIDER_X, 348);
        agora.put(GC.SLIDER_Y, 25);
        agora.put(GC.SLIDER_W, 104);
        agora.put(GC.PURCHASE_X, 18);
        agora.put(GC.PURCHASE_Y, 453);
        agora.put(GC.PURCHASE_W, 104);
        agora.put(GC.CANCEL_X, 138);
        agora.put(GC.BANK_H_X, 451);
        agora.put(GC.BANK_H_Y, 417);
        agora.put(GC.BANK_V_X, 549);
        agora.put(GC.BANK_V_Y, 404);
        agora.put(GC.BANK_V_W, 53);
        if (is_double) {
            agora.replaceAll(mul2);
        }

    }

    private void iHouse(boolean is_double) {
        house = new HashMap<>();
        // budget
        house.put(CH.BUDGET_H, 36);
        house.put(CH.DEBT_H_X, 443);
        house.put(CH.DEBT_H_Y, 395);
        house.put(CH.DEBT_H_H, 20);
        house.put(CH.DEBT_V_Y, 384);
        house.put(CH.SLIDER_W, 84);
        house.put(CH.SLIDER_X, 416);
        house.put(CH.SLIDER_Y, 288);
        house.put(CH.TAX_H_X, 447);
        house.put(CH.TAX_H_Y, 283);
        house.put(CH.TAX_V_W, 52);
        house.put(CH.TAX_V_X, 564);
        house.put(CH.TITHE_SKIM_H_X, 423);
        house.put(CH.UNIT_PAY_H_X, 430);
        house.put(CH.LOYALTY_H_X, 500);

        house.put(CH.LOYALTY_P_X, 510);
        house.put(CH.LOYALTY_P_Y, 288);
        house.put(CH.LOYALTY_P_W, 42);
        house.put(CH.LOYALTY_P_H, 93);
        house.put(CH.LOYALTY_P_TAX_Y, 15);
        house.put(CH.LOYALTY_P_PAY_Y, 87);

        // leader
        house.put(CH.LEADER_H_W, 230);
        house.put(CH.LEADER_H_X, 20);
        house.put(CH.LEADER_H_Y, 236);
        house.put(CH.STATE_X, 40);
        house.put(CH.STATE_Y, 318);
        house.put(CH.STATE_W, 27);
        house.put(CH.STATE_S, 28);


        if (is_double) {
            house.replaceAll(mul2);
        }

    }

    private void iDiplomacy(boolean is_double) {
        diplomacy_selector = new HashMap<>();
        diplomacy_selector.put(CD.WIN_X, 20);
        diplomacy_selector.put(CD.WIN_Y, 60);
        int x = diplomacy_selector.get(CD.WIN_X) - 1;
        int y = diplomacy_selector.get(CD.WIN_Y) - 1;
        diplomacy_selector.put(CD.WIN_W, 600);
        diplomacy_selector.put(CD.WIN_H, 360);
        diplomacy_selector.put(CD.WIN_H_X, 95 - x);
        diplomacy_selector.put(CD.WIN_H_Y, 85 - y);

        diplomacy_selector.put(CD.ROW1_X, 58 - x);
        diplomacy_selector.put(CD.ROW1_Y, 98 - y);
        diplomacy_selector.put(CD.ROW2_X, 128 - x);
        diplomacy_selector.put(CD.ROW2_Y, 238 - y);
        diplomacy_selector.put(CD.ROW_W, 140);
        diplomacy_selector.put(CD.ROW_H_Y, 213 - y);

        diplomacy_selector.put(CD.EXIT_X, 268 - x);
        diplomacy_selector.put(CD.EXIT_Y, 378 - y);
        diplomacy_selector.put(CD.EXIT_W, 114);
        diplomacy_selector.put(CD.EXIT_H, 16);

        if (is_double) {
            diplomacy_selector.replaceAll(mul2);
        }

    }

    private void iDiplomacyWindow(boolean is_double) {
        diplomacy_window = new HashMap<>();
        diplomacy_window.put(CDW.GIVE_H_Y, 43);
        diplomacy_window.put(CDW.GIVE_X, 329);
        diplomacy_window.put(CDW.GIVE_Y, 52);
        diplomacy_window.put(CDW.GIVE_W, 281);
        diplomacy_window.put(CDW.GIVE_H, 19);
        diplomacy_window.put(CDW.ROW_H, 28);
        diplomacy_window.put(CDW.TAKE_Y, 154);
        diplomacy_window.put(CDW.DMG_X, 298);
        diplomacy_window.put(CDW.DMG_Y, 260);

        diplomacy_window.put(CDW.R_WIN_Y, 90);
        int y = diplomacy_window.get(CDW.R_WIN_Y) - 1;
        diplomacy_window.put(CDW.R_WIN_H, 300);
        diplomacy_window.put(CDW.R_ACCEPT_X, 272);
        diplomacy_window.put(CDW.R_ACCEPT_Y, 363 - y);
        diplomacy_window.put(CDW.R_ACCEPT_W, 95);
        diplomacy_window.put(CDW.R_ACCEPT_H, 16);
        diplomacy_window.put(CDW.R_BUTTON_W, 123);
        diplomacy_window.put(CDW.R_RESPONCE_X, 10);
        diplomacy_window.put(CDW.R_RESPONCE_Y, 350 - y);


        if (is_double) {
            diplomacy_window.replaceAll(mul2);
        }

    }

    private void iGalaxyWindow(boolean is_double) {
        galaxy_window = new HashMap<>();
        galaxy_window.put(CGW.MAP_X, 84);
        galaxy_window.put(CGW.MAP_Y, 10);
        galaxy_window.put(CGW.MAP_W, 473);
        galaxy_window.put(CGW.MAP_H, 433);
        galaxy_window.put(CGW.MAP_MARGIN, 11);

        galaxy_window.put(CGW.BUT_X, 268);
        galaxy_window.put(CGW.BUT_Y, 453);
        galaxy_window.put(CGW.BUT_W, 105);
        galaxy_window.put(CGW.BUT_H, 18);
        galaxy_window.put(CGW.SQUARE, 9);

        galaxy_window.put(CGW.PMAP_X, 20);
        galaxy_window.put(CGW.PMAP_Y, 5);
        galaxy_window.put(CGW.PMAP_W, 600);
        galaxy_window.put(CGW.PMAP_H, 450);

        galaxy_window.put(CGW.PBUT_X, 518);
        galaxy_window.put(CGW.PBUT_Y, 460);
        galaxy_window.put(CGW.PBUT_W, 104);
        galaxy_window.put(CGW.PBUT_H, 16);
        galaxy_window.put(CGW.PNAME_X, 22);
        galaxy_window.put(CGW.PNAME_Y, 473);

        if (is_double) {
            galaxy_window.replaceAll(mul2);
        }

    }

    private void iOptionsWindow(boolean is_double) {
        options_window = new HashMap<>();
        options_window.put(OW.WIN_X, 0);
        options_window.put(OW.WIN_Y, 0);
        options_window.put(OW.WIN_W, 640);
        options_window.put(OW.WIN_H, 480);

        options_window.put(OW.COL1_X, 10);
        options_window.put(OW.COL1_Y, 10);
        options_window.put(OW.BOX_W, 100);
        options_window.put(OW.BOX_H, 16);

        options_window.put(OW.EXIT_X, 520);
        options_window.put(OW.EXIT_Y, 455);
        options_window.put(OW.EXIT_W, 114);
        options_window.put(OW.EXIT_H, 16);

        if (is_double) {
            options_window.replaceAll(mul2);
        }
    }

    private void iStrategy(boolean is_double) {
        strategy_selector = new HashMap<>();
        strategy_selector.put(SS.WIN_X, 160);
        strategy_selector.put(SS.WIN_Y, 160);
        int x = strategy_selector.get(SS.WIN_X);
        int y = strategy_selector.get(SS.WIN_Y);

        strategy_selector.put(SS.WIN_W, 320);
        strategy_selector.put(SS.WIN_H, 170);
        strategy_selector.put(SS.BUTTON_X, 178 - x);
        strategy_selector.put(SS.BUTTON_Y, 208 - y);
        strategy_selector.put(SS.BUTTON_W, 284);
        strategy_selector.put(SS.BUTTON_H, 16);
        strategy_selector.put(SS.ROW_H, 25);
        strategy_selector.put(SS.HEADER_X, 207 - x);
        strategy_selector.put(SS.HEADER_Y, 191 - y);

        if (is_double) {
            strategy_selector.replaceAll(mul2);
        }

    }

    private void iGroupFinder(boolean is_double) {
        group_finder = new HashMap<>();
        group_finder.put(GF.BUTTON_X, 144);
        group_finder.put(GF.BUTTON_Y, 459);
        group_finder.put(GF.BUTTON_W, 101);
        group_finder.put(GF.BUTTON_H, 14);
        group_finder.put(GF.BUTTON2_X, 272);
        group_finder.put(GF.BUTTON3_X, 399);
        group_finder.put(GF.GAL_MAP_X, 9);
        group_finder.put(GF.GAL_MAP_Y, 9);
        group_finder.put(GF.PLAN_MAP_X, 15);
        group_finder.put(GF.PLAN_MAP_Y, 129);
        group_finder.put(GF.PLAN_NAME_Y, 111);
        group_finder.put(GF.PLAN_NAME_H, 14);
        group_finder.put(GF.SENTRY_Y, 433);

        if (is_double) { // Fix #86
            group_finder.replaceAll(mul2);
        }

    }

    private void iAgoraAutobuy(boolean is_double) {
        agora_auto_buy = new HashMap<>();
        agora_auto_buy.put(AAB.WIN_X, 60);
        agora_auto_buy.put(AAB.WIN_Y, 160);
        int x = agora_auto_buy.get(AAB.WIN_X);
        int y = agora_auto_buy.get(AAB.WIN_Y);

        agora_auto_buy.put(AAB.WIN_W, 520);
        agora_auto_buy.put(AAB.WIN_H, 232);
        agora_auto_buy.put(AAB.BUTTON_X, 98);
        agora_auto_buy.put(AAB.BUTTON_X2, 318);
        agora_auto_buy.put(AAB.BUTTON_Y, 205);
        agora_auto_buy.put(AAB.BUTTON_W, 104);
        agora_auto_buy.put(AAB.BUTTON_H, 16);

        agora_auto_buy.put(AAB.COL_TEXT_X, 52);
        agora_auto_buy.put(AAB.COL_TEXT_X2, 332);
        agora_auto_buy.put(AAB.COL_IMG_X, 11);
        agora_auto_buy.put(AAB.COL_IMG_X2, 270);

        agora_auto_buy.put(AAB.ROW_TEXT_Y, 113);
        agora_auto_buy.put(AAB.ROW_TEXT_Y2, 125);
        agora_auto_buy.put(AAB.ROW_IMG_Y, 100);

        agora_auto_buy.put(AAB.ROW_H, 32);

        agora_auto_buy.put(AAB.HEADER_X, 207 - x);
        agora_auto_buy.put(AAB.HEADER_Y, 24);
        agora_auto_buy.put(AAB.HEADER_Y2, 44);
        agora_auto_buy.put(AAB.HEADER_Y3, 74);
        agora_auto_buy.put(AAB.HEADER_Y4, 160);
        agora_auto_buy.put(AAB.HEADER_Y5, 185);


        if (is_double) {
            agora_auto_buy.replaceAll(mul2);
        }

    }

    private void iCityInfo(boolean is_double) {
        city_info = new HashMap<>();
        city_info.put(CIW.T_X, 159);
        city_info.put(CIW.T_Y, 45);
        city_info.put(CIW.T_W, 461);
        city_info.put(CIW.T_H, 303);
        city_info.put(CIW.H_Y, 23);

        if (is_double) {
            city_info.replaceAll(mul2);
        }

    }

    private class Doubler implements BiFunction<Enum, Integer, Integer> {

        @Override
        public Integer apply(Enum t, Integer u) {
            return 2 * u;
        }
    }
}
