package ru.neoflex.accountservice.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.accountservice.entity.BankAccountInfo;
import ru.neoflex.accountservice.service.BankAccountInfoService;

import java.util.List;
import java.util.UUID;

@Api(tags = {"Getting BankAccountInfo"})
@RestController
@RequestMapping("/api")
public class BankAccountInfoController {

    private final BankAccountInfoService bankAccountInfoService;

    public BankAccountInfoController(BankAccountInfoService bankAccountInfoService) {
        this.bankAccountInfoService = bankAccountInfoService;
    }

    @GetMapping("/account-info")
    @ApiOperation(value = "Get BankAccountInfo by uuid", notes = "This method returns BankAccountInfo by uuid")
    public BankAccountInfo getAccountInfo(
            @RequestParam("uuid")
            @ApiParam(
                    name = "uuid",
                    type = "String",
                    value = "BankAccountInfo uuid",
                    required = true)
                    UUID uuid
    ) {
        return bankAccountInfoService.getBankAccountInfoById(uuid);
    }

    @GetMapping("/account-infos")
    @ApiOperation(value = "Get BankAccountInfo list")
    public List<BankAccountInfo> getAccountInfos() {
        return bankAccountInfoService.getBankAccountInfos();
    }

    @GetMapping("/account-infos-by-type")
    @ApiOperation(value = "Get BankAccountInfo by type")
    public List<BankAccountInfo> getAccountByType(
            @RequestParam("type")
            @ApiParam(
                    name = "type",
                    type = "String",
                    value = "BankAccountInfo types: 'SAVINGS', 'MONEYMARKET', 'CHECKING', 'IRA' or 'CD'",
                    required = true)
                    String type
    ) {
        return bankAccountInfoService.getBankAccountByType(type);
    }

    @GetMapping("/account-infos-by-period")
    @ApiOperation(value = "Get BankAccountInfo by period in dd-MM-yyyy format")
    public List<BankAccountInfo> getAccountsByPeriod(
            @RequestParam
            @ApiParam(
                    name = "startDate",
                    type = "String",
                    value = "BankAccountInfo start period date",
                    required = true)
                    String startDate,
            @RequestParam
            @ApiParam(
                    name = "endDate",
                    type = "String",
                    value = "BankAccountInfo end period date",
                    required = true)
                    String endDate
    ) {
        return bankAccountInfoService.getByPeriod(startDate, endDate);
    }
}