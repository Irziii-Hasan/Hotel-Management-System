package com.system.hotelmanagement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.system.hotelmanagement.dto.room.CreateRoomDTO;
import com.system.hotelmanagement.dto.room.ViewRoomDTO;
import com.system.hotelmanagement.service.RoomService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("hotelmanagementsystem/admin/room")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping
    public String showRooms(Model model) {
        List<ViewRoomDTO> rooms = roomService.showRoomsList();
        model.addAttribute("rooms", rooms);
        return "roommanagement";
    }

    @GetMapping("/add")
    public String showAddRoomForm(Model model) {
        model.addAttribute("room", new CreateRoomDTO());
        return "addroom";
    }

    @PostMapping("/add")
    public String addRoom(@ModelAttribute("room") CreateRoomDTO room) {
        roomService.addRoom(room);
        return "redirect:/hotelmanagementsystem/admin/room";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return "redirect:/hotelmanagementsystem/admin/room";
    }



    @GetMapping("/edit/{id}")
    public String showEditRoom(@PathVariable Long id, Model model) {
        ViewRoomDTO room = roomService.getRoomById(id);
        model.addAttribute("room", room);
        return "editroom"; 
    }

    @PostMapping("/edit/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute CreateRoomDTO updateRoom) {
        roomService.updateRoom(id, updateRoom);
        return "redirect:/hotelmanagementsystem/admin/room";
    }
}